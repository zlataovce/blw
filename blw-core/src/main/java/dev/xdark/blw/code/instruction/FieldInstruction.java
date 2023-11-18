package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.JavaOpcodes;
import dev.xdark.blw.type.ClassType;
import dev.xdark.blw.type.InstanceType;
import org.jetbrains.annotations.NotNull;

public final class FieldInstruction implements MemberInstruction {
	private final int opcode;
	private final InstanceType owner;
	private final String name;
	private final ClassType descriptor;

	public FieldInstruction(int opcode, @NotNull InstanceType owner, @NotNull String name, @NotNull ClassType descriptor) {
		this.opcode = opcode;
		this.owner = owner;
		this.name = name;
		this.descriptor = descriptor;
	}

	@Override
	public int opcode() {
		return opcode;
	}

	@Override
	public @NotNull InstanceType owner() {
		return owner;
	}

	@Override
	public @NotNull String name() {
		return name;
	}

	@Override
	public @NotNull ClassType type() {
		return descriptor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FieldInstruction that = (FieldInstruction) o;

		if (opcode != that.opcode) return false;
		if (!owner.equals(that.owner)) return false;
		if (!name.equals(that.name)) return false;
		return descriptor.equals(that.descriptor);
	}

	@Override
	public int hashCode() {
		int result = opcode;
		result = 31 * result + owner.hashCode();
		result = 31 * result + name.hashCode();
		result = 31 * result + descriptor.hashCode();
		return result;
	}

	@Override
	public String toString() {
		String suffix = owner.internalName() + "." + name + " " + descriptor.descriptor();
		return switch (opcode) {
			case JavaOpcodes.GETFIELD -> "get-field ";
			case JavaOpcodes.PUTFIELD -> "put-field ";
			case JavaOpcodes.GETSTATIC -> "get-static ";
			case JavaOpcodes.PUTSTATIC -> "put-static ";
			default -> "?-field ";
		} + suffix;
	}
}
