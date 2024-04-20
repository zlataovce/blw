package dev.xdark.blw.constantpool;

public record EntryMethodType(int descriptorIndex) implements Entry {


    @Override
    public int tag() {
        return Tag.MethodType;
    }
}
