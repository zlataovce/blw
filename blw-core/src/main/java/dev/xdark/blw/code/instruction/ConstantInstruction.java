package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.ExtensionOpcodes;
import dev.xdark.blw.constant.Constant;
import dev.xdark.blw.constant.OfType;
import dev.xdark.blw.constant.OfString;
import dev.xdark.blw.constant.OfMethodHandle;
import dev.xdark.blw.constant.OfDynamic;
import dev.xdark.blw.constant.OfFloat;
import dev.xdark.blw.constant.OfDouble;
import dev.xdark.blw.constant.OfLong;
import dev.xdark.blw.constant.OfInt;

import java.util.Objects;

public abstract sealed class ConstantInstruction<C extends Constant> implements Instruction
		permits ConstantInstruction.String,
		ConstantInstruction.MethodHandle,
		ConstantInstruction.Dynamic,
		ConstantInstruction.Long,
		ConstantInstruction.Double,
		ConstantInstruction.Int,
		ConstantInstruction.Float,
		ConstantInstruction.Type {
	protected final C constant;

	protected ConstantInstruction(C constant) {
		this.constant = constant;
	}

	public final C constant() {
		return constant;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ConstantInstruction<?> that = (ConstantInstruction<?>) o;

		return Objects.equals(constant, that.constant);
	}

	@Override
	public int hashCode() {
		return constant != null ? constant.hashCode() : 0;
	}

	@SuppressWarnings("unchecked")
	public static <C extends Constant> ConstantInstruction<C> wrap(C constant) {
		if (constant instanceof OfString c) {
			return (ConstantInstruction<C>) new String(c);
		} else if (constant instanceof OfMethodHandle c) {
			return (ConstantInstruction<C>) new MethodHandle(c);
		} else if (constant instanceof OfType c) {
			return (ConstantInstruction<C>) new Type(c);
		} else if (constant instanceof OfDynamic c) {
			return (ConstantInstruction<C>) new Dynamic(c);
		} else if (constant instanceof OfLong c) {
			return (ConstantInstruction<C>) new Long(c);
		} else if (constant instanceof OfDouble c) {
			return (ConstantInstruction<C>) new Double(c);
		} else if (constant instanceof OfInt c) {
			return (ConstantInstruction<C>) new Int(c);
		} else if (constant instanceof OfFloat c) {
			return (ConstantInstruction<C>) new Float(c);
		} else {
			throw new IllegalStateException("Unexpected value: " + constant);
		}
	}

	public static final class String extends ConstantInstruction<OfString> {

		public String(OfString constant) {
			super(constant);
		}

		@Override
		public int opcode() {
			return ExtensionOpcodes.STRING_CONSTANT;
		}

		@Override
		public java.lang.String toString() {
			return "string " + constant.value();
		}
	}

	public static final class MethodHandle extends ConstantInstruction<OfMethodHandle> {

		public MethodHandle(OfMethodHandle constant) {
			super(constant);
		}

		@Override
		public int opcode() {
			return ExtensionOpcodes.METHOD_HANDLE_CONSTANT;
		}

		@Override
		public java.lang.String toString() {
			return "handle " + constant.value();
		}
	}

	public static final class Dynamic extends ConstantInstruction<OfDynamic> {

		public Dynamic(OfDynamic constant) {
			super(constant);
		}

		@Override
		public int opcode() {
			return ExtensionOpcodes.DYNAMIC_CONSTANT;
		}

		@Override
		public java.lang.String toString() {
			return "dynamic " + constant.value();
		}
	}

	public static final class Long extends ConstantInstruction<OfLong> {

		public Long(OfLong constant) {
			super(constant);
		}

		@Override
		public int opcode() {
			return ExtensionOpcodes.LONG_CONSTANT;
		}

		@Override
		public java.lang.String toString() {
			return "long " + constant.value();
		}
	}

	public static final class Double extends ConstantInstruction<OfDouble> {

		public Double(OfDouble constant) {
			super(constant);
		}

		@Override
		public int opcode() {
			return ExtensionOpcodes.DOUBLE_CONSTANT;
		}

		@Override
		public java.lang.String toString() {
			return "double " + constant.value();
		}
	}

	public static final class Int extends ConstantInstruction<OfInt> {

		public Int(OfInt constant) {
			super(constant);
		}

		@Override
		public int opcode() {
			return ExtensionOpcodes.INT_CONSTANT;
		}

		@Override
		public java.lang.String toString() {
			return "int " + constant.value();
		}
	}

	public static final class Float extends ConstantInstruction<OfFloat> {

		public Float(OfFloat constant) {
			super(constant);
		}

		@Override
		public int opcode() {
			return ExtensionOpcodes.FLOAT_CONSTANT;
		}

		@Override
		public java.lang.String toString() {
			return "float " + constant.value();
		}
	}

	public static final class Type extends ConstantInstruction<OfType> {

		public Type(OfType constant) {
			super(constant);
		}

		@Override
		public int opcode() {
			return ExtensionOpcodes.TYPE_CONSTANT;
		}

		@Override
		public java.lang.String toString() {
			return "type " + constant.value();
		}
	}
}
