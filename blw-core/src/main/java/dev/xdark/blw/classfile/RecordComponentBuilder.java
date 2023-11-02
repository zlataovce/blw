package dev.xdark.blw.classfile;

import dev.xdark.blw.type.ClassType;

public interface RecordComponentBuilder<B extends RecordComponentBuilder<B>>
		extends AnnotatedBuilder<RecordComponent, B>, NamedBuilder<RecordComponent, B>,
		TypedBuilder<ClassType, RecordComponent, B>, SignedBuilder<RecordComponent, B> {
}
