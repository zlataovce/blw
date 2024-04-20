package dev.xdark.blw.code;

import dev.xdark.blw.type.InstanceType;

public record TryCatchBlock(Label start, Label end, Label handler, InstanceType type) {

}
