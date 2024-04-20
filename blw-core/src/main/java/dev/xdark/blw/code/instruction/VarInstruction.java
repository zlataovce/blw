package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.JavaOpcodes;

public record VarInstruction(int opcode, int variableIndex) implements Instruction {

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
