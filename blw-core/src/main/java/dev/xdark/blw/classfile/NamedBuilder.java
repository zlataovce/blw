package dev.xdark.blw.classfile;

import dev.xdark.blw.util.Builder;

public interface NamedBuilder<E extends Named, B extends NamedBuilder<E, B>>
		extends Builder<E>, Self<B> {
	String name();

	B name(String name);
}
