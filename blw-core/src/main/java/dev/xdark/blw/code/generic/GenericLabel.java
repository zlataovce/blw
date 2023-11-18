package dev.xdark.blw.code.generic;

import dev.xdark.blw.code.Label;

public final class GenericLabel implements Label {
	private int lineNumber = UNSET;
	private int index = UNSET;

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int getLineNumber() {
		return lineNumber;
	}

	@Override
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GenericLabel label = (GenericLabel) o;

		if (lineNumber != label.lineNumber) return false;
		return index == label.index;
	}

	@Override
	public int hashCode() {
		int result = lineNumber;
		result = 31 * result + index;
		return result;
	}

	@Override
	public String toString() {
		return "label_" + index;
	}
}
