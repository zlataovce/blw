package dev.xdark.blw.constantpool;

public record EntryNameAndType(int nameIndex, int typeIndex) implements Entry {


    @Override
    public int tag() {
        return Tag.NameAndType;
    }
}
