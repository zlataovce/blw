package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.JavaOpcodes;
import dev.xdark.blw.type.ObjectType;
import org.jetbrains.annotations.NotNull;

public record InstanceofInstruction(ObjectType type) implements Instruction {
	public InstanceofInstruction(@NotNull ObjectType type) {
		this.type = type;
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
	public String toString() {
		return "instanceof " + type.descriptor();
	}
}
