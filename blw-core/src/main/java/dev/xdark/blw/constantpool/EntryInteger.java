package dev.xdark.blw.constantpool;

import dev.xdark.blw.constant.OfInt;

public record EntryInteger(OfInt value) implements Entry {


    @Override
    public int tag() {
        return Tag.Integer;
    }
}
