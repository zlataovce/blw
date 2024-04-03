package dev.xdark.blw.annotation;

public final class ElementBoolean implements Element {
	public static final ElementBoolean TRUE = new ElementBoolean(true);
	public static final ElementBoolean FALSE = new ElementBoolean(false);
	private final boolean value;

	private ElementBoolean(boolean value) {
		this.value = value;
	}

	public static Element of(boolean b) {
		if (b) return TRUE;
		else return FALSE;
	}

	public boolean value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ElementBoolean that = (ElementBoolean) o;

		return value == that.value;
	}

	@Override
	public int hashCode() {
		return (value ? 1 : 0);
	}

	@Override
	public String toString() {
		return "EBool{" + value + '}';
	}
}
