package dev.xdark.blw.constant;

public record OfInt(int value) implements Constant {


	@Override
	public void accept(ConstantSink sink) {
		sink.acceptInt(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof OfInt that)) return false;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(value);
	}
}
