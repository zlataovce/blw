package dev.xdark.blw.constantpool;

import dev.xdark.blw.constant.OfString;

public record EntryUtf8(OfString value) implements Entry {


    @Override
    public int tag() {
        return Tag.Utf8;
    }
}
