package dev.xdark.blw.classfile;

import dev.xdark.blw.type.Type;
import dev.xdark.blw.util.Builder;
import org.jetbrains.annotations.NotNull;

public interface MemberBuilder<T extends Type, M extends Member<T>, B extends MemberBuilder<T, M, B>>
		extends AnnotatedBuilder<M, B>, AccessibleBuilder<M, B>, NamedBuilder<M, B>,
		TypedBuilder<T, M, B>, SignedBuilder<M, B>, Builder<M> {
	@NotNull
	default MemberIdentifier getIdentifier() {
		return new MemberIdentifier(name(), type());
	}
}
