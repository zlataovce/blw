package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.JavaOpcodes;
import dev.xdark.blw.code.Label;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record TableSwitchInstruction(int min, @NotNull Label defaultTarget,
									 @NotNull List<Label> targets) implements SwitchInstruction {

	@Override
	public int opcode() {
		return JavaOpcodes.TABLESWITCH;
	}

	@Override
	public Label select(int key) {
		key -= min();
		List<Label> targets;
		if (key >= 0 && key < (targets = targets()).size()) {
			return targets.get(key);
		}
		return defaultTarget();
	}

	@Override
	public int[] keys() {
		int[] keys = new int[targets().size()];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = min() + i;
		}
		return keys;
	}
}
