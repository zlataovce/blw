package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Label;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Stream;

public sealed interface SwitchInstruction extends BranchInstruction permits LookupSwitchInstruction, TableSwitchInstruction {
	@NotNull
	Label defaultTarget();

	@NotNull
	List<Label> targets();

	Label select(int key);

	int[] keys();

	@Override
	default @NotNull Stream<Label> allTargets() {
		return Stream.concat(Stream.of(defaultTarget()), targets().stream());
	}
}
