package dev.xdark.blw.classfile;

import dev.xdark.blw.type.Type;
import org.jetbrains.annotations.NotNull;

public non-sealed interface Member<T extends Type> extends Named, Typed<T>, Accessible, Annotated, Signed {
	@NotNull
	default MemberIdentifier getIdentifier() {
		return new MemberIdentifier(name(), type());
	}
}
