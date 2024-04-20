package dev.xdark.blw.constant;

public record OfFloat(float value) implements Constant {


	@Override
	public void accept(ConstantSink sink) {
		sink.acceptFloat(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof OfFloat that)) return false;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Float.hashCode(value);
	}
}
