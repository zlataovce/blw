package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;

public final class SimpleInstruction implements Instruction {

	private final int opcode;

	public SimpleInstruction(int opcode) {
		this.opcode = opcode;
	}

	@Override
	public int opcode() {
		return opcode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SimpleInstruction that = (SimpleInstruction) o;

		return opcode == that.opcode;
	}

	@Override
	public int hashCode() {
		return opcode;
	}

	@Override
	public String toString() {
		return "insn-" + opcode;
	}
}
