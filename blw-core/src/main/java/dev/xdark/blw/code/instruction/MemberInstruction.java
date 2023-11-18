package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.type.ObjectType;
import dev.xdark.blw.type.Type;
import org.jetbrains.annotations.NotNull;

public interface MemberInstruction extends Instruction {
	@NotNull
	ObjectType owner();

	@NotNull
	String name();

	@NotNull
	Type type();
}
