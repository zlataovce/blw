package dev.xdark.blw.classfile;

import dev.xdark.blw.annotation.Annotation;
import dev.xdark.blw.annotation.AnnotationBuilder;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.util.Builder;
import dev.xdark.blw.util.Split;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static dev.xdark.blw.util.SneakyCast.cast;

public interface AnnotatedBuilder<E extends Annotated, B extends AnnotatedBuilder<E, B>>
		extends Self<B>, Builder<E> {
	/**
	 * @param <A>
	 * 		Anno builder type.
	 *
	 * @return Mutable list of current visible runtime annotation builders.
	 */
	<A extends AnnotationBuilder<A>> @NotNull List<A> getVisibleRuntimeAnnotations();

	/**
	 * @param <A>
	 * 		Anno builder type.
	 *
	 * @return Mutable list of current invisible runtime annotation builders.
	 */
	<A extends AnnotationBuilder<A>> @NotNull List<A> getInvisibleRuntimeAnnotation();

	/**
	 * Builds the contents of {@link #getVisibleRuntimeAnnotations()}.
	 *
	 * @return List of runtime annotations.
	 */
	default @NotNull List<Annotation> buildVisibleRuntimeAnnotations() {
		return getVisibleRuntimeAnnotations().stream().map(Builder::build).toList();
	}

	/**
	 * Builds the contents of {@link #getInvisibleRuntimeAnnotation()}.
	 *
	 * @return List of invisible annotations.
	 */
	default @NotNull List<Annotation> buildInvisibleRuntimeAnnotation() {
		return getInvisibleRuntimeAnnotation().stream().map(Builder::build).toList();
	}

	/**
	 * @param type
	 * 		Annotation type.
	 * @param <A>
	 * 		Anno builder type.
	 *
	 * @return Split of the current builder, and the new builder for the given annotation.
	 */
	default <A extends AnnotationBuilder<A>> @NotNull Split<B, A> addVisibleRuntimeAnnotation(@NotNull InstanceType type) {
		A builder = AnnotationBuilder.newAnnotationBuilder(type);
		addVisibleRuntimeAnnotation(builder);
		return cast(Split.of(this, builder));
	}

	/**
	 * @param builder
	 * 		Annotation builder.
	 * @param <A>
	 * 		Anno builder type.
	 */
	default <A extends AnnotationBuilder<A>> void addVisibleRuntimeAnnotation(@NotNull A builder) {
		getVisibleRuntimeAnnotations().add(cast(builder));
	}

	/**
	 * @param index
	 * 		Index to put the builder at within {@link #getVisibleRuntimeAnnotations()}.
	 * @param builder
	 * 		Annotation builder.
	 * @param <A>
	 * 		Anno builder type.
	 */
	default <A extends AnnotationBuilder<A>> void setVisibleRuntimeAnnotation(int index, @NotNull A builder) {
		getVisibleRuntimeAnnotations().set(index, cast(builder));
	}

	/**
	 * @param type
	 * 		Annotation type.
	 * @param <A>
	 * 		Anno builder type.
	 *
	 * @return Split of the current builder, and the new builder for the given annotation.
	 */
	default <A extends AnnotationBuilder<A>> @NotNull Split<B, A> addInvisibleRuntimeAnnotation(@NotNull InstanceType type) {
		A builder = AnnotationBuilder.newAnnotationBuilder(type);
		addInvisibleRuntimeAnnotation(builder);
		return cast(Split.of(this, builder));
	}

	/**
	 * @param builder
	 * 		Annotation builder.
	 * @param <A>
	 * 		Anno builder type.
	 */
	default <A extends AnnotationBuilder<A>> void addInvisibleRuntimeAnnotation(@NotNull A builder) {
		getInvisibleRuntimeAnnotation().add(cast(builder));
	}

	/**
	 * @param index
	 * 		Index to put the builder at within {@link #getInvisibleRuntimeAnnotation()}.
	 * @param builder
	 * 		Annotation builder.
	 * @param <A>
	 * 		Anno builder type.
	 */
	default <A extends AnnotationBuilder<A>> void setInvisibleRuntimeAnnotation(int index, @NotNull A builder) {
		getInvisibleRuntimeAnnotation().set(index, cast(builder));
	}
}
