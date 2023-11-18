package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.JavaOpcodes;
import dev.xdark.blw.type.ObjectType;
import org.jetbrains.annotations.NotNull;

public final class CheckCastInstruction implements Instruction {
	private final ObjectType type;

	public CheckCastInstruction(@NotNull ObjectType type) {
		this.type = type;
	}

	@Override
	public int opcode() {
		return JavaOpcodes.CHECKCAST;
	}

	@NotNull
	public ObjectType type() {
		return type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CheckCastInstruction that = (CheckCastInstruction) o;

		return type.equals(that.type);
	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}

	@Override
	public String toString() {
		return "checkcast " + type.descriptor();
	}
}
