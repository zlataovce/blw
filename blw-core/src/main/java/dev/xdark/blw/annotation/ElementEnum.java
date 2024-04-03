package dev.xdark.blw.annotation;

import dev.xdark.blw.type.InstanceType;

public final class ElementEnum implements Element {
	private final InstanceType type;
	private final String name;

	public ElementEnum(InstanceType type, String name) {
		this.type = type;
		this.name = name;
	}

	public InstanceType type() {
		return type;
	}

	public String name() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ElementEnum that = (ElementEnum) o;

		if (!type.equals(that.type)) return false;
		return name.equals(that.name);
	}

	@Override
	public int hashCode() {
		int result = type.hashCode();
		result = 31 * result + name.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "EEnum{" + type + '.' + name + '}';
	}
}
