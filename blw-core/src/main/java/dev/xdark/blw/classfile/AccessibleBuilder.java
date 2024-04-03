package dev.xdark.blw.classfile;

import dev.xdark.blw.util.Builder;

public interface AccessibleBuilder<E extends Accessible, B extends AccessibleBuilder<E, B>>
		extends Self<B>, Builder<E> {
	B accessFlags(int accessFlags);

	int accessFlags();
}
