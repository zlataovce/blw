package dev.xdark.blw.classfile;

import dev.xdark.blw.type.Type;
import dev.xdark.blw.util.Builder;

public interface TypedBuilder<T extends Type, E extends Typed<T>, B extends TypedBuilder<T, E, B>>
		extends Self<B>, Builder<E> {
	T type();

	B type(T type);
}
