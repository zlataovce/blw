package dev.xdark.blw.annotation;

import dev.xdark.blw.annotation.generic.GenericAnnotationBuilder;
import dev.xdark.blw.annotation.generic.GenericArrayBuilder;
import dev.xdark.blw.classfile.TypedBuilder;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.util.Builder;
import dev.xdark.blw.util.Reflectable;
import dev.xdark.blw.util.Split;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

public interface AnnotationBuilder<B extends AnnotationBuilder<B>>
		extends TypedBuilder<InstanceType, Annotation, B> {
	@NotNull
	Set<String> elementKeys();

	@NotNull
	Map<String, Reflectable<Element>> elements();

	B element(@NotNull String name, @NotNull Element element);

	B element(@NotNull String name, @NotNull Builder<? extends Element> element);

	@SuppressWarnings("unchecked")
	default <A extends AnnotationBuilder<A>> Split<B, A> annotation(String name, InstanceType type) {
		A annotationBuilder = newAnnotationBuilder(type);
		element(name, annotationBuilder);
		return Split.of((B) this, annotationBuilder);
	}

	@SuppressWarnings("unchecked")
	default <A extends ElementArrayBuilder<A>> Split<B, A> array(String name) {
		A annotationBuilder = (A) new GenericArrayBuilder();
		element(name, annotationBuilder);
		return Split.of((B) this, annotationBuilder);
	}

	@NotNull
	@SuppressWarnings("unchecked")
	static <A extends AnnotationBuilder<A>> A newAnnotationBuilder(@NotNull InstanceType type) {
		return (A) new GenericAnnotationBuilder(type);
	}
}
