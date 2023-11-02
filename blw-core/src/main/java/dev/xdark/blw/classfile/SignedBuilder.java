package dev.xdark.blw.classfile;

import dev.xdark.blw.util.Builder;
import org.jetbrains.annotations.Nullable;

public interface SignedBuilder<E extends Signed, B extends SignedBuilder<E, B>>
		extends Self<B>, Builder<E> {
	@Nullable
	String signature();

	B signature(@Nullable String signature);
}
