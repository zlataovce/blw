package dev.xdark.blw.constant;

import dev.xdark.blw.type.MethodHandle;

public record OfMethodHandle(MethodHandle value) implements ReferenceConstant<MethodHandle> {


	@Override
	public void accept(ConstantSink sink) {
		sink.acceptMethodHandle(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof OfMethodHandle that)) return false;
		return value.equals(that.value);
	}

}
