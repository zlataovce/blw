package dev.xdark.blw.simulation;

import dev.xdark.blw.code.Label;
import dev.xdark.blw.code.instruction.*;
import dev.xdark.blw.code.Instruction;

public interface ExecutionEngine {

	void label(Label label);

	void execute(SimpleInstruction instruction);

	void execute(ConstantInstruction<?> instruction);

	void execute(VarInstruction instruction);

	void execute(LookupSwitchInstruction instruction);

	void execute(TableSwitchInstruction instruction);

	void execute(InstanceofInstruction instruction);

	void execute(CheckCastInstruction instruction);

	void execute(AllocateInstruction instruction);

	void execute(AllocateMultiDimArrayInstruction instruction);

	void execute(MethodInstruction instruction);

	void execute(FieldInstruction instruction);

	void execute(InvokeDynamicInstruction instruction);

	void execute(ImmediateJumpInstruction instruction);

	void execute(ConditionalJumpInstruction instruction);

	void execute(VariableIncrementInstruction instruction);

	void execute(PrimitiveConversionInstruction instruction);

	void execute(Instruction instruction);
}
