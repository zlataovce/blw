package dev.xdark.blw.constantpool;

import dev.xdark.blw.type.InvokeDynamic;

public record EntryInvokeDynamic(InvokeDynamic value) implements Entry {


    @Override
    public int tag() {
        return Tag.InvokeDynamic;
    }
}
