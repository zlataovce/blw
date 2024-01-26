package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Label;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public final class ImmediateJumpInstruction implements BranchInstruction {
	private final int opcode;
	private final Label target;

	public ImmediateJumpInstruction(int opcode, @NotNull Label target) {
		this.opcode = opcode;
		this.target = target;
	}

	@NotNull
	public Label target() {
		return target;
	}

	@Override
	public int opcode() {
		return opcode;
	}

	@Override
	public @NotNull Stream<Label> targetsStream() {
		return Stream.of(target);
	}

	@Override
	public boolean hasFallthrough() {
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ImmediateJumpInstruction that = (ImmediateJumpInstruction) o;

		if (opcode != that.opcode) return false;
		return target.equals(that.target);
	}

	@Override
	public int hashCode() {
		int result = opcode;
		result = 31 * result + target.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "jump to " + target;
	}
}
