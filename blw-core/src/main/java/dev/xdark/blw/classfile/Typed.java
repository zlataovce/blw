package dev.xdark.blw.classfile;

import dev.xdark.blw.annotation.Annotation;
import dev.xdark.blw.type.Type;

public sealed interface Typed<T extends Type> permits ClassFileView, Annotation, Member, RecordComponent {
	T type();
}
