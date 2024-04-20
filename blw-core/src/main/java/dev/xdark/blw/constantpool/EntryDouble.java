package dev.xdark.blw.constantpool;

import dev.xdark.blw.constant.OfDouble;

public record EntryDouble(OfDouble value) implements Entry {


    @Override
    public int tag() {
        return Tag.Double;
    }
}
