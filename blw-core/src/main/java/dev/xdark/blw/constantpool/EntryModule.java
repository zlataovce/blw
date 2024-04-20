package dev.xdark.blw.constantpool;

public record EntryModule(int nameIndex) implements Entry {


    @Override
    public int tag() {
        return Tag.Module;
    }
}
