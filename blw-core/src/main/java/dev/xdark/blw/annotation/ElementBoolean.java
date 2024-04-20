package dev.xdark.blw.annotation;

public record ElementBoolean(boolean value) implements Element {

    public static final ElementBoolean TRUE = new ElementBoolean(true);
    public static final ElementBoolean FALSE = new ElementBoolean(false);

    public static Element of(boolean b) {
        if (b) return TRUE;
        else return FALSE;
    }

}
