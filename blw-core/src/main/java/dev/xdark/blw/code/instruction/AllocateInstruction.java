package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.ExtensionOpcodes;
import dev.xdark.blw.type.ObjectType;
import org.jetbrains.annotations.NotNull;

public final class AllocateInstruction implements Instruction {

	private final ObjectType type;

	public AllocateInstruction(@NotNull ObjectType type) {
		this.type = type;
	}

	@Override
	public int opcode() {
		return ExtensionOpcodes.ALLOCATE;
	}

	@NotNull
	public ObjectType type() {
		return type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AllocateInstruction that = (AllocateInstruction) o;

		return type.equals(that.type);
	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}

	@Override
	public String toString() {
		return "allocate " + type.descriptor();
	}
}
