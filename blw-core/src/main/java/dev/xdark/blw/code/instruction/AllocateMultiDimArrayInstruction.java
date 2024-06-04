package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.ExtensionOpcodes;
import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.type.ArrayType;
import org.jetbrains.annotations.NotNull;

public record AllocateMultiDimArrayInstruction(ArrayType type, int dimensions) implements Instruction {

	@Override
	public int opcode() {
		return ExtensionOpcodes.ALLOCATE_MULTI_ARRAY;
	}

	@Override
	@NotNull
	public ArrayType type() {
		return type;
	}

	@Override
	public String toString() {
		return "allocate-multi-array " + type.componentType() + "[" + dimensions + "]" + "[]".repeat(type().dimensions() - 1);
	}
}
