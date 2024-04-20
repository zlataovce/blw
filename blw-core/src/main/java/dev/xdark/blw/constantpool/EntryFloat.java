package dev.xdark.blw.constantpool;

import dev.xdark.blw.constant.OfFloat;

public record EntryFloat(OfFloat value) implements Entry {


    @Override
    public int tag() {
        return Tag.Float;
    }
}
