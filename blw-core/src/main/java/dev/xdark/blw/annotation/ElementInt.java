package dev.xdark.blw.annotation;

public final class ElementInt implements Element {
	private final int value;

	public ElementInt(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ElementInt that = (ElementInt) o;

		return value == that.value;
	}

	@Override
	public int hashCode() {
		return value;
	}

	@Override
	public String toString() {
		return "EInt{" + value + '}';
	}
}
