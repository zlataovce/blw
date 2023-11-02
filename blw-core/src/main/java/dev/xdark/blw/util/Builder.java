package dev.xdark.blw.util;

public interface Builder<E> extends Reflectable<E> {
	E build();

	@Override
	default E reflectAs() {
		return build();
	}
}
