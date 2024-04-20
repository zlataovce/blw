package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.JavaOpcodes;
import dev.xdark.blw.type.ObjectType;
import org.jetbrains.annotations.NotNull;

public record CheckCastInstruction(ObjectType type) implements Instruction {
	public CheckCastInstruction(@NotNull ObjectType type) {
		this.type = type;
	}

	@Override
	public int opcode() {
		return JavaOpcodes.CHECKCAST;
	}

	@Override
	public String toString() {
		return "checkcast " + type.descriptor();
	}
}
