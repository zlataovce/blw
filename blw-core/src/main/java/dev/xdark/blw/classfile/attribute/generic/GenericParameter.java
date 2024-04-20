package dev.xdark.blw.classfile.attribute.generic;

import dev.xdark.blw.classfile.attribute.Parameter;

public record GenericParameter(int accessFlags, String name) implements Parameter {


}
