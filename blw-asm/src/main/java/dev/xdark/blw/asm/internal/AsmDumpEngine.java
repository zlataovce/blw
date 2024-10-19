package dev.xdark.blw.asm.internal;

import dev.xdark.blw.code.Label;
import dev.xdark.blw.code.instruction.*;
import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.constant.Constant;
import dev.xdark.blw.constant.OfType;
import dev.xdark.blw.constant.OfString;
import dev.xdark.blw.constant.OfMethodHandle;
import dev.xdark.blw.constant.OfDynamic;
import dev.xdark.blw.constant.OfFloat;
import dev.xdark.blw.constant.OfDouble;
import dev.xdark.blw.constant.OfLong;
import dev.xdark.blw.constant.OfInt;
import dev.xdark.blw.simulation.ExecutionEngine;
import dev.xdark.blw.type.ArrayType;
import dev.xdark.blw.type.ClassType;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.type.ObjectType;
import dev.xdark.blw.type.PrimitiveType;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static dev.xdark.blw.code.ExtensionOpcodes.*;
import static dev.xdark.blw.code.JavaOpcodes.*;

public class AsmDumpEngine implements ExecutionEngine, PrimitiveConversion {
	protected final LabelMapping labelMapping;
	protected final MethodVisitor mv;

	public AsmDumpEngine(LabelMapping labelMapping, MethodVisitor mv) {
		this.labelMapping = labelMapping;
		this.mv = mv;
	}

	@Override
	public void label(Label label) {
		MethodVisitor mv = this.mv;
		org.objectweb.asm.Label l = labelMapping.getLabel(label);
		mv.visitLabel(l);
		int line = label.getLineNumber();
		if (line != Label.UNSET) {
			mv.visitLineNumber(line, l);
		}
	}

	@Override
	public void execute(SimpleInstruction instruction) {
		mv.visitInsn(instruction.opcode());
	}

	@Override
	public void execute(ConstantInstruction<?> instruction) {
		MethodVisitor mv = this.mv;
		Constant constant = instruction.constant();
		// It is faster if we do switch on opcode
		switch (instruction.opcode()) {
			case STRING_CONSTANT -> mv.visitLdcInsn(((OfString) constant).value());
			case METHOD_HANDLE_CONSTANT ->
					mv.visitLdcInsn(Util.unwrapMethodHandle(((OfMethodHandle) constant).value()));
			case DYNAMIC_CONSTANT -> mv.visitLdcInsn(Util.unwrapConstantDynamic(((OfDynamic) constant).value()));
			case LONG_CONSTANT -> {
				long value = ((OfLong) constant).value();
				if(value == 0L) {
					mv.visitInsn(LCONST_0);
				} else if(value == 1L) {
					mv.visitInsn(LCONST_1);
				} else {
					mv.visitLdcInsn(value);
				}
			}
			case DOUBLE_CONSTANT -> {
				double value = ((OfDouble) constant).value();
				if(value == 0D) {
					mv.visitInsn(DCONST_0);
				} else if(value == 1D) {
					mv.visitInsn(DCONST_1);
				} else {
					mv.visitLdcInsn(value);
				}
			}
			case INT_CONSTANT -> {
				int value = ((OfInt) constant).value();
				if(value >= -1 && value <= 5) {
					mv.visitInsn(ICONST_0 + value);
				} else if(value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE) {
					mv.visitIntInsn(BIPUSH, value);
				} else if(value >= Short.MIN_VALUE && value <= Short.MAX_VALUE) {
					mv.visitIntInsn(SIPUSH, value);
				} else {
					mv.visitLdcInsn(value);
				}
			}
			case FLOAT_CONSTANT -> {
				float value = ((OfFloat) constant).value();
				if(value == 0F) {
					mv.visitInsn(FCONST_0);
				} else if(value == 1F) {
					mv.visitInsn(FCONST_1);
				} else if(value == 2F) {
					mv.visitInsn(FCONST_2);
				} else {
					mv.visitLdcInsn(value);
				}
			}
			case TYPE_CONSTANT -> mv.visitLdcInsn(Util.unwrapType(((OfType) constant).value()));
		}
	}

	@Override
	public void execute(VarInstruction instruction) {
		mv.visitVarInsn(instruction.opcode(), instruction.variableIndex());
	}

	@Override
	public void execute(LookupSwitchInstruction instruction) {
		LabelMapping mapping = labelMapping;
		mv.visitLookupSwitchInsn(
				mapping.getLabel(instruction.defaultTarget()),
				instruction.keys(),
				instruction.targets().stream().map(mapping::getLabel).toArray(org.objectweb.asm.Label[]::new)
		);
	}

	@Override
	public void execute(TableSwitchInstruction instruction) {
		LabelMapping mapping = labelMapping;
		int min = instruction.min();
		mv.visitTableSwitchInsn(
				min,
				min + instruction.targets().size() - 1,
				mapping.getLabel(instruction.defaultTarget()),
				instruction.targets().stream().map(mapping::getLabel).toArray(org.objectweb.asm.Label[]::new)
		);
	}

	@Override
	public void execute(InstanceofInstruction instruction) {
		mv.visitTypeInsn(Opcodes.INSTANCEOF, instruction.type().internalName());
	}

	@Override
	public void execute(CheckCastInstruction instruction) {
		mv.visitTypeInsn(Opcodes.CHECKCAST, instruction.type().internalName());
	}

	@Override
	public void execute(AllocateInstruction instruction) {
		MethodVisitor mv = this.mv;
		ObjectType type = instruction.type();
		if (type instanceof InstanceType instance) {
			mv.visitTypeInsn(Opcodes.NEW, instance.internalName());
		} else {
			ArrayType arrayType = (ArrayType) type;
			ClassType component = arrayType.componentType();
			if (component instanceof ObjectType objectComponent) {
				mv.visitTypeInsn(Opcodes.ANEWARRAY, objectComponent.internalName());
			} else if (component instanceof PrimitiveType primitiveComponent) {
				mv.visitIntInsn(Opcodes.NEWARRAY, primitiveComponent.kind());
			}
		}
	}

	@Override
	public void execute(AllocateMultiDimArrayInstruction instruction) {
		mv.visitMultiANewArrayInsn(instruction.type().descriptor(), instruction.dimensions());
	}

	@Override
	public void execute(MethodInstruction instruction) {
		mv.visitMethodInsn(instruction.opcode(), instruction.owner().internalName(), instruction.name(), instruction.type().descriptor(), instruction.isInterface());
	}

	@Override
	public void execute(FieldInstruction instruction) {
		mv.visitFieldInsn(instruction.opcode(), instruction.owner().internalName(), instruction.name(), instruction.type().descriptor());
	}

	@Override
	public void execute(InvokeDynamicInstruction instruction) {
		mv.visitInvokeDynamicInsn(
				instruction.name(),
				instruction.type().descriptor(),
				Util.unwrapMethodHandle(instruction.bootstrapHandle()),
				instruction.args().stream().map(Util::unwrapConstant).toArray()
		);
	}

	@Override
	public void execute(ImmediateJumpInstruction instruction) {
		mv.visitJumpInsn(instruction.opcode(), labelMapping.getLabel(instruction.target()));
	}

	@Override
	public void execute(ConditionalJumpInstruction instruction) {
		mv.visitJumpInsn(instruction.opcode(), labelMapping.getLabel(instruction.target()));
	}

	@Override
	public void execute(VariableIncrementInstruction instruction) {
		mv.visitIincInsn(instruction.variableIndex(), instruction.incrementBy());
	}

	@Override
	public void execute(PrimitiveConversionInstruction instruction) {
		instruction.accept(this);
	}

	@Override
	public void execute(Instruction instruction) {
		throw new IllegalStateException("Unknown instruction %s".formatted(instruction));
	}

	@Override
	public void i2l() {
		mv.visitInsn(I2L);
	}

	@Override
	public void i2f() {
		mv.visitInsn(I2F);
	}

	@Override
	public void i2d() {
		mv.visitInsn(I2D);
	}

	@Override
	public void l2i() {
		mv.visitInsn(L2I);
	}

	@Override
	public void l2f() {
		mv.visitInsn(L2F);
	}

	@Override
	public void l2d() {
		mv.visitInsn(L2D);
	}

	@Override
	public void f2i() {
		mv.visitInsn(F2I);
	}

	@Override
	public void f2l() {
		mv.visitInsn(F2L);
	}

	@Override
	public void f2d() {
		mv.visitInsn(F2D);
	}

	@Override
	public void d2i() {
		mv.visitInsn(D2I);
	}

	@Override
	public void d2l() {
		mv.visitInsn(D2L);
	}

	@Override
	public void d2f() {
		mv.visitInsn(D2F);
	}

	@Override
	public void i2b() {
		mv.visitInsn(I2B);
	}

	@Override
	public void i2c() {
		mv.visitInsn(I2C);
	}

	@Override
	public void i2s() {
		mv.visitInsn(I2S);
	}
}
