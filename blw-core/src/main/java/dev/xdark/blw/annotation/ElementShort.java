package dev.xdark.blw.annotation;

public final class ElementShort implements Element {
	private final short value;

	public ElementShort(short value) {
		this.value = value;
	}

	public short value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ElementShort that = (ElementShort) o;

		return value == that.value;
	}

	@Override
	public int hashCode() {
		return value;
	}

	@Override
	public String toString() {
		return "EShort{" + value + '}';
	}
}
