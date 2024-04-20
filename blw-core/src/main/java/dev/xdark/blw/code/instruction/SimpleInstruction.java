package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;

public record SimpleInstruction(int opcode) implements Instruction {

	@Override
	public String toString() {
		return "insn-" + opcode;
	}
}
