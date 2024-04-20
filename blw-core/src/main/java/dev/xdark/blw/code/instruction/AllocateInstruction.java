package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.ExtensionOpcodes;
import dev.xdark.blw.type.ObjectType;
import org.jetbrains.annotations.NotNull;

public record AllocateInstruction(ObjectType type) implements Instruction {

	public AllocateInstruction(@NotNull ObjectType type) {
		this.type = type;
	}

	@Override
	public int opcode() {
		return ExtensionOpcodes.ALLOCATE;
	}

	@Override
	@NotNull
	public ObjectType type() {
		return type;
	}

	@Override
	public String toString() {
		return "allocate " + type.descriptor();
	}
}
