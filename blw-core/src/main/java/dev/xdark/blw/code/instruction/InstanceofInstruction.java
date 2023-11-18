package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.JavaOpcodes;
import dev.xdark.blw.type.ObjectType;
import org.jetbrains.annotations.NotNull;

public final class InstanceofInstruction implements Instruction {
	private final ObjectType type;

	public InstanceofInstruction(@NotNull ObjectType type) {
		this.type = type;
	}

	@NotNull
	public ObjectType type() {
		return type;
	}

	@Override
	public int opcode() {
		return JavaOpcodes.INSTANCEOF;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		InstanceofInstruction that = (InstanceofInstruction) o;

		return type.equals(that.type);
	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}

	@Override
	public String toString() {
		return "instanceof " + type.descriptor();
	}
}
