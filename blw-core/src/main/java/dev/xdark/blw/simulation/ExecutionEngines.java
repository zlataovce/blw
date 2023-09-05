package dev.xdark.blw.simulation;

import dev.xdark.blw.code.instruction.AllocateInstruction;
import dev.xdark.blw.code.instruction.CheckCastInstruction;
import dev.xdark.blw.code.instruction.ConditionalJumpInstruction;
import dev.xdark.blw.code.instruction.ConstantInstruction;
import dev.xdark.blw.code.instruction.FieldInstruction;
import dev.xdark.blw.code.instruction.ImmediateJumpInstruction;
import dev.xdark.blw.code.instruction.InstanceofInstruction;
import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.instruction.InvokeDynamicInstruction;
import dev.xdark.blw.code.instruction.LookupSwitchInstruction;
import dev.xdark.blw.code.instruction.MethodInstruction;
import dev.xdark.blw.code.instruction.PrimitiveConversionInstruction;
import dev.xdark.blw.code.instruction.SimpleInstruction;
import dev.xdark.blw.code.instruction.TableSwitchInstruction;
import dev.xdark.blw.code.instruction.VarInstruction;
import dev.xdark.blw.code.instruction.VariableIncrementInstruction;

public final class ExecutionEngines {

	private ExecutionEngines() {
	}

	public static void execute(ExecutionEngine engine, Instruction instruction) {
		if (instruction instanceof SimpleInstruction sim) {
			engine.execute(sim);
		} else if (instruction instanceof LookupSwitchInstruction lsw) {
			engine.execute(lsw);
		} else if (instruction instanceof TableSwitchInstruction tsw) {
			engine.execute(tsw);
		} else if (instruction instanceof ConditionalJumpInstruction cj) {
			engine.execute(cj);
		} else if (instruction instanceof ImmediateJumpInstruction ij) {
			engine.execute(ij);
		} else if (instruction instanceof VarInstruction var) {
			engine.execute(var);
		} else if (instruction instanceof VariableIncrementInstruction vi) {
			engine.execute(vi);
		} else if (instruction instanceof MethodInstruction m) {
			engine.execute(m);
		} else if (instruction instanceof FieldInstruction f) {
			engine.execute(f);
		} else if (instruction instanceof InvokeDynamicInstruction indy) {
			engine.execute(indy);
		} else if (instruction instanceof AllocateInstruction a) {
			engine.execute(a);
		} else if (instruction instanceof CheckCastInstruction cc) {
			engine.execute(cc);
		} else if (instruction instanceof InstanceofInstruction i) {
			engine.execute(i);
		} else if (instruction instanceof ConstantInstruction<?>) {
			engine.execute((ConstantInstruction<?>) instruction);
		} else if (instruction instanceof PrimitiveConversionInstruction i) {
			engine.execute(i);
		} else {
			engine.execute(instruction);
		}
	}
}
