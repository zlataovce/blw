package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.JavaOpcodes;
import dev.xdark.blw.type.MethodType;
import dev.xdark.blw.type.ObjectType;
import org.jetbrains.annotations.NotNull;

public final class MethodInstruction implements MemberInstruction {
	private final int opcode;
	private final ObjectType owner;
	private final String name;
	private final MethodType descriptor;
	private final boolean isInterface;

	public MethodInstruction(int opcode, ObjectType owner, String name, MethodType descriptor, boolean isInterface) {
		this.opcode = opcode;
		this.owner = owner;
		this.name = name;
		this.descriptor = descriptor;
		this.isInterface = isInterface;
	}

	@Override
	public int opcode() {
		return opcode;
	}

	@Override
	public @NotNull ObjectType owner() {
		return owner;
	}

	@Override
	public @NotNull String name() {
		return name;
	}

	@Override
	public @NotNull MethodType type() {
		return descriptor;
	}

	public boolean isInterface() {
		return isInterface;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MethodInstruction that = (MethodInstruction) o;

		if (opcode != that.opcode) return false;
		if (isInterface != that.isInterface) return false;
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
		result = 31 * result + (isInterface ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		String suffix = owner.internalName() + "." + name + descriptor.descriptor();
		return switch (opcode) {
			case JavaOpcodes.INVOKEVIRTUAL -> "invoke-virtual";
			case JavaOpcodes.INVOKESPECIAL -> "invoke-special";
			case JavaOpcodes.INVOKESTATIC -> "invoke-static";
			case JavaOpcodes.INVOKEINTERFACE -> "invoke-interface";
			default -> "invoke-? ";
		} + suffix;
	}
}
