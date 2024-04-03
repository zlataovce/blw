package dev.xdark.blw.annotation;

public final class ElementChar implements Element {
	private final char value;

	public ElementChar(char value) {
		this.value = value;
	}

	public char value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ElementChar that = (ElementChar) o;

		return value == that.value;
	}

	@Override
	public int hashCode() {
		return value;
	}

	@Override
	public String toString() {
		return "EChar{" + value + '}';
	}
}
