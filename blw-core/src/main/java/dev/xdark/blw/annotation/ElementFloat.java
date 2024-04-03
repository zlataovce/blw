package dev.xdark.blw.annotation;

public final class ElementFloat implements Element {
	private final float value;

	public ElementFloat(float value) {
		this.value = value;
	}

	public float value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ElementFloat that = (ElementFloat) o;

		return Float.compare(value, that.value) == 0;
	}

	@Override
	public int hashCode() {
		return (value != 0.0f ? Float.floatToIntBits(value) : 0);
	}

	@Override
	public String toString() {
		return "EFloat{" + value + '}';
	}
}
