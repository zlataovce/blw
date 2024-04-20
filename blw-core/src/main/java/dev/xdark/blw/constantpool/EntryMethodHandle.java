package dev.xdark.blw.constantpool;

public record EntryMethodHandle(int referenceKind, int referenceIndex) implements Entry {


    @Override
    public int tag() {
        return Tag.MethodHandle;
    }
}
