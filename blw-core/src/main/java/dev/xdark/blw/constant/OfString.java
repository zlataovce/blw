package dev.xdark.blw.constant;

public record OfString(String value) implements ReferenceConstant<String> {


	@Override
	public void accept(ConstantSink sink) {
		sink.acceptString(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof OfString that)) return false;
		return value.equals(that.value);
	}

}
