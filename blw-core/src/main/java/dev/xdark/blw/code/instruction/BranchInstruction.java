package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.Label;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public interface BranchInstruction extends Instruction {
	@NotNull
	Stream<Label> allTargets();
}
