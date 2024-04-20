package dev.xdark.blw.annotation;

public sealed interface Element permits Annotation, ElementArray, ElementBoolean, ElementByte, ElementChar, ElementDouble, ElementEnum, ElementFloat, ElementInt, ElementLong, ElementShort, ElementString, ElementType {
}
