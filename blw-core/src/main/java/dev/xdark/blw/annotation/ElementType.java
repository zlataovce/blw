package dev.xdark.blw.annotation;

import dev.xdark.blw.type.ObjectType;

public final class ElementType implements Element {
	private final ObjectType value;

	public ElementType(ObjectType value) {
		this.value = value;
	}

	public ObjectType value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ElementType that = (ElementType) o;

		return value.equals(that.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return "EType{" + value + '}';
	}
}
