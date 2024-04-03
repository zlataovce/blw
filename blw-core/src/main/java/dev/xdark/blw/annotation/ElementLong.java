package dev.xdark.blw.annotation;

public final class ElementLong implements Element {
	private final long value;

	public ElementLong(long value) {
		this.value = value;
	}

	public long value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ElementLong that = (ElementLong) o;

		return value == that.value;
	}

	@Override
	public int hashCode() {
		return (int) (value ^ (value >>> 32));
	}

	@Override
	public String toString() {
		return "ELong{" + value + '}';
	}
}
