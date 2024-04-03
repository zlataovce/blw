package dev.xdark.blw.annotation;

public final class ElementString implements Element {
	private final String value;

	public ElementString(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ElementString that = (ElementString) o;

		return value.equals(that.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return "EString{" + value + '}';
	}
}
