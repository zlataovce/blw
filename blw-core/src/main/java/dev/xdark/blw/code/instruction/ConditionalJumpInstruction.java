package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Label;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public record ConditionalJumpInstruction(int opcode, Label target) implements BranchInstruction {
	public ConditionalJumpInstruction(int opcode, @NotNull Label target) {
		this.opcode = opcode;
		this.target = target;
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
	public String toString() {
		return "cond-jump to " + target;
	}
}
