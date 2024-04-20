package dev.xdark.blw.constant;

public record OfDouble(double value) implements Constant {


	@Override
	public void accept(ConstantSink sink) {
		sink.acceptDouble(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof OfDouble that)) return false;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Double.hashCode(value);
	}
}
