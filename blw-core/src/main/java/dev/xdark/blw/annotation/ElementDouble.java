package dev.xdark.blw.annotation;

public final class ElementDouble implements Element {
	private final double value;

	public ElementDouble(double value) {
		this.value = value;
	}

	public double value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ElementDouble that = (ElementDouble) o;

		return Double.compare(value, that.value) == 0;
	}

	@Override
	public int hashCode() {
		long temp = Double.doubleToLongBits(value);
		return (int) (temp ^ (temp >>> 32));
	}

	@Override
	public String toString() {
		return "EDouble{" + value + '}';
	}
}
