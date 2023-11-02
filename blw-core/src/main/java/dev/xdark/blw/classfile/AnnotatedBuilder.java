package dev.xdark.blw.classfile;

import dev.xdark.blw.annotation.AnnotationBuilder;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.util.Builder;
import dev.xdark.blw.util.Split;

public interface AnnotatedBuilder<E extends Annotated, B extends AnnotatedBuilder<E, B>>
		extends Self<B>, Builder<E> {
	<A extends AnnotationBuilder<A>>
	Split<B, A> putVisibleRuntimeAnnotation(InstanceType type);

	<A extends AnnotationBuilder<A>>
	Split<B, A> putInvisibleRuntimeAnnotation(InstanceType type);
}
