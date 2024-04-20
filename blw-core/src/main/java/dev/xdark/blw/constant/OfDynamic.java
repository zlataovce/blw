package dev.xdark.blw.constant;

import dev.xdark.blw.type.ConstantDynamic;

public record OfDynamic(ConstantDynamic value) implements ReferenceConstant<ConstantDynamic> {


	@Override
	public void accept(ConstantSink sink) {
		sink.acceptDynamic(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof OfDynamic that)) return false;
		return value.equals(that.value);
	}

}
