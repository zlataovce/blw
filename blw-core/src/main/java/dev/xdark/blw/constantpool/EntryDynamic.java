package dev.xdark.blw.constantpool;

import dev.xdark.blw.constant.OfDynamic;

public record EntryDynamic(OfDynamic value) implements Entry {


    @Override
    public int tag() {
        return Tag.Dynamic;
    }
}
