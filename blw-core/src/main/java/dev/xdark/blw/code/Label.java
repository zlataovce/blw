package dev.xdark.blw.code;

public non-sealed interface Label extends CodeElement {
	int UNSET = -1;

	int getIndex();

	void setIndex(int index);

	int getLineNumber();

	void setLineNumber(int lineNumber);
}
