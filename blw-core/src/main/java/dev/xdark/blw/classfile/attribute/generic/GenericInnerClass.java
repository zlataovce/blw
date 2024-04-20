package dev.xdark.blw.classfile.attribute.generic;

import dev.xdark.blw.classfile.attribute.InnerClass;
import dev.xdark.blw.type.InstanceType;
import org.jetbrains.annotations.Nullable;

public record GenericInnerClass(int accessFlags, InstanceType type, InstanceType outerType,
                                String innerName) implements InnerClass {


    @Override
    public @Nullable InstanceType outerType() {
        return outerType;
    }

    @Override
    public @Nullable String innerName() {
        return innerName;
    }
}
