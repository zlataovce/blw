package dev.xdark.blw.constantpool;

public record EntryString(int utf8Index) implements Entry {


    @Override
    public int tag() {
        return Tag.String;
    }
}
