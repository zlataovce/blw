package dev.xdark.blw.annotation;

public record ElementByte(byte value) implements Element {

    private static final int CACHE_SIZE = 256;
    private static final ElementByte[] CACHE = new ElementByte[CACHE_SIZE];

    public static Element of(byte b) {
        return CACHE[((b - Byte.MIN_VALUE) % CACHE_SIZE)];
    }

    static {
        int j = 0;
        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++)
            CACHE[j++] = new ElementByte((byte) i);
    }

}
