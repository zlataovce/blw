package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.JavaOpcodes;

public final class VarInstruction implements Instruction {
	private final int opcode;
	private final int variableIndex;

	public VarInstruction(int opcode, int variableIndex) {
		this.opcode = opcode;
		this.variableIndex = variableIndex;
	}

	@Override
	public int opcode() {
		return opcode;
	}

	public int variableIndex() {
		return variableIndex;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		VarInstruction that = (VarInstruction) o;

		if (opcode != that.opcode) return false;
		return variableIndex == that.variableIndex;
	}

	@Override
	public int hashCode() {
		int result = opcode;
		result = 31 * result + variableIndex;
		return result;
	}

	@Override
	public String toString() {
		return switch (opcode) {
			case JavaOpcodes.ILOAD -> "iload";
			case JavaOpcodes.LLOAD -> "lload";
			case JavaOpcodes.FLOAD -> "fload";
			case JavaOpcodes.DLOAD -> "dload";
			case JavaOpcodes.ALOAD -> "aload";
			case JavaOpcodes.ISTORE -> "istore";
			case JavaOpcodes.LSTORE -> "lstore";
			case JavaOpcodes.FSTORE -> "fstore";
			case JavaOpcodes.DSTORE -> "dstore";
			case JavaOpcodes.ASTORE -> "astore";
			default -> "unknown-var";
		} + " v" + variableIndex;
	}
}
