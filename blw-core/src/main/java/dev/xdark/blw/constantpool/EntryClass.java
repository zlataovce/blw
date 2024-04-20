package dev.xdark.blw.constantpool;

public record EntryClass(int nameIndex) implements Entry {


    @Override
    public int tag() {
        return Tag.Class;
    }
}
