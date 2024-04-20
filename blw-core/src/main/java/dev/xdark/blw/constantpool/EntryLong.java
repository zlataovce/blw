package dev.xdark.blw.constantpool;

import dev.xdark.blw.constant.OfLong;

public record EntryLong(OfLong value) implements Entry {


    @Override
    public int tag() {
        return Tag.Long;
    }
}
