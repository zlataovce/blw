package dev.xdark.blw.constantpool;

public record EntryPackage(int nameIndex) implements Entry {


    @Override
    public int tag() {
        return Tag.Package;
    }
}
