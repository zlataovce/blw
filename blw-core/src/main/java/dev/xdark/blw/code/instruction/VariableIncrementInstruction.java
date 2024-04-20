package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.JavaOpcodes;

public record VariableIncrementInstruction(int variableIndex, int incrementBy) implements Instruction {


	@Override
	public int opcode() {
		return JavaOpcodes.IINC;
	}

	@Override
	public String toString() {
		return "iinc v" + variableIndex + ((incrementBy >= 0) ? "+" : "") + incrementBy;
	}
}
