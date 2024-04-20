package dev.xdark.blw.annotation;

import dev.xdark.blw.annotation.Element;
import dev.xdark.blw.type.InstanceType;

public record ElementEnum(InstanceType type, String name) implements Element {


}
