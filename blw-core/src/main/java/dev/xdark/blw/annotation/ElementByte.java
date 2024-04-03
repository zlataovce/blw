package dev.xdark.blw.annotation;

public final class ElementByte implements Element {
	private static final int CACHE_SIZE = 256;
	private static final ElementByte[] CACHE = new ElementByte[CACHE_SIZE];
	private final byte value;

	private ElementByte(byte value) {
		this.value = value;
	}

	public static Element of(byte b) {
		return CACHE[((b - Byte.MIN_VALUE) % CACHE_SIZE)];
	}

	public byte value() {
		return value;
	}

	static {
		int j = 0;
		for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++)
			CACHE[j++] = new ElementByte((byte) i);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ElementByte that = (ElementByte) o;

		return value == that.value;
	}

	@Override
	public int hashCode() {
		return value;
	}

	@Override
	public String toString() {
		return "EByte{" + value + '}';
	}
}
