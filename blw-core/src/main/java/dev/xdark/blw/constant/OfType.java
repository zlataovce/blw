package dev.xdark.blw.constant;

import dev.xdark.blw.type.Type;

public record OfType(Type value) implements ReferenceConstant<Type> {


	@Override
	public void accept(ConstantSink sink) {
		sink.acceptType(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof OfType that)) return false;
		return value.equals(that.value);
	}

}
