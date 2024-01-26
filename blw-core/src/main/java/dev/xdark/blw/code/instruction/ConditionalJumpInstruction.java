package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Label;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

public final class ConditionalJumpInstruction implements BranchInstruction {
	private final int opcode;
	private final Label target;

	public ConditionalJumpInstruction(int opcode, @NotNull Label target) {
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
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ConditionalJumpInstruction that = (ConditionalJumpInstruction) o;

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
		return "cond-jump to " + target;
	}
}
