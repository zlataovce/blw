package dev.xdark.blw.code.attribute.generic;

import dev.xdark.blw.code.attribute.Local;
import dev.xdark.blw.code.Label;
import dev.xdark.blw.type.ClassType;
import org.jetbrains.annotations.Nullable;

public record GenericLocal(Label start, Label end, int index, String name, ClassType type,
						   String signature) implements Local {


	@Override
	public @Nullable String signature() {
		return signature;
	}
}
