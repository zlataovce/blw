package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.JavaOpcodes;
import dev.xdark.blw.code.Label;

import java.util.Arrays;
import java.util.List;

public record LookupSwitchInstruction(int[] keys, Label defaultTarget,
									  List<Label> targets) implements SwitchInstruction {


	@Override
	public int opcode() {
		return JavaOpcodes.LOOKUPSWITCH;
	}


	@Override
	public Label select(int key) {
		int idx = Arrays.binarySearch(keys(), key);
		return idx < 0 ? defaultTarget() : targets().get(idx);
	}
}
