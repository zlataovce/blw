package dev.xdark.blw.code;

import org.jetbrains.annotations.NotNull;

public non-sealed interface Label extends CodeElement, Comparable<Label> {
	int UNSET = -1;

	int getIndex();

	void setIndex(int index);

	int getLineNumber();

	void setLineNumber(int lineNumber);

	@Override
	default int compareTo(@NotNull Label o) {
		return Integer.compare(getIndex(), o.getIndex());
	}
}
