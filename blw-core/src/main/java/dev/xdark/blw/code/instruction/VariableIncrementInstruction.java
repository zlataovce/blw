package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.JavaOpcodes;

public final class VariableIncrementInstruction implements Instruction {
	private final int variableIndex, incrementBy;

	public VariableIncrementInstruction(int variableIndex, int incrementBy) {
		this.variableIndex = variableIndex;
		this.incrementBy = incrementBy;
	}

	public int variableIndex() {
		return variableIndex;
	}

	public int incrementBy() {
		return incrementBy;
	}

	@Override
	public int opcode() {
		return JavaOpcodes.IINC;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		VariableIncrementInstruction that = (VariableIncrementInstruction) o;

		if (variableIndex != that.variableIndex) return false;
		return incrementBy == that.incrementBy;
	}

	@Override
	public int hashCode() {
		int result = variableIndex;
		result = 31 * result + incrementBy;
		return result;
	}

	@Override
	public String toString() {
		return "iinc v" + variableIndex + ((incrementBy >= 0) ? "+" : "") + incrementBy;
	}
}
