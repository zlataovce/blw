package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.annotation.Annotation;
import dev.xdark.blw.annotation.AnnotationBuilder;
import dev.xdark.blw.annotation.generic.GenericAnnotationBuilder;
import dev.xdark.blw.classfile.AnnotatedBuilder;
import dev.xdark.blw.classfile.RecordComponent;
import dev.xdark.blw.classfile.RecordComponentBuilder;
import dev.xdark.blw.internal.BuilderShadow;
import dev.xdark.blw.type.ClassType;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.util.Builder;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract sealed class GenericRecordComponentBuilder implements AnnotatedBuilder, BuilderShadow<RecordComponent>
permits GenericRecordComponentBuilder.Root, GenericRecordComponentBuilder.Nested {
	protected final List<AnnotationBuilder> visibleRuntimeAnnotations = new ArrayList<>();
	protected final List<AnnotationBuilder> invisibleRuntimeAnnotation = new ArrayList<>();
	protected String name;
	protected ClassType type;
	protected String signature;

	@Override
	public RecordComponent build() {
		return new GenericRecordComponent(name, signature, type, visibleRuntimeAnnotations(), invisibleRuntimeAnnotation());
	}

	@Override
	@SuppressWarnings("all")
	public @Nullable AnnotationBuilder.Nested<? extends AnnotatedBuilder> visibleRuntimeAnnotation(InstanceType type) {
		var builder = new GenericAnnotationBuilder.Nested<>(type, (Builder) this);
		visibleRuntimeAnnotations.add(builder);

		return (AnnotationBuilder.Nested<? extends AnnotatedBuilder>) (Object) builder;
	}

	@Override
	@SuppressWarnings("all")
	public @Nullable AnnotationBuilder.Nested<? extends AnnotatedBuilder> invisibleRuntimeAnnotation(InstanceType type) {
		var builder = new GenericAnnotationBuilder.Nested<>(type, (Builder) this);
		invisibleRuntimeAnnotation.add(builder);

		//noinspection unchecked
		return (AnnotationBuilder.Nested<? extends AnnotatedBuilder>) (Object) builder;
	}

	protected final List<Annotation> visibleRuntimeAnnotations() {
		//noinspection unchecked
		return visibleRuntimeAnnotations.stream().map(builder -> ((BuilderShadow<Annotation>) builder).build()).toList();
	}

	protected final List<Annotation> invisibleRuntimeAnnotation() {
		//noinspection unchecked
		return invisibleRuntimeAnnotation.stream().map(builder -> ((BuilderShadow<Annotation>) builder).build()).toList();
	}

	public static final class Root extends GenericRecordComponentBuilder implements RecordComponentBuilder.Root {
		@Override
		public RecordComponentBuilder name(String name) {
			this.name = name;
			return this;
		}

		@Override
		public RecordComponentBuilder type(ClassType type) {
			this.type = type;
			return this;
		}

		@Override
		public RecordComponentBuilder signature(String signature) {
			this.signature = signature;
			return this;
		}

		@Override
		public @Nullable AnnotationBuilder.Nested<RecordComponentBuilder.Root> visibleRuntimeAnnotation(InstanceType type) {
			//noinspection unchecked
			return (AnnotationBuilder.Nested<RecordComponentBuilder.Root>) super.visibleRuntimeAnnotation(type);
		}

		@Override
		public @Nullable AnnotationBuilder.Nested<RecordComponentBuilder.Root> invisibleRuntimeAnnotation(InstanceType type) {
			//noinspection unchecked
			return (AnnotationBuilder.Nested<RecordComponentBuilder.Root>) super.invisibleRuntimeAnnotation(type);
		}

		@Override
		public RecordComponent reflectAs() {
			return super.reflectAs();
		}
	}

	public static final class Nested<U extends Builder> extends GenericRecordComponentBuilder implements RecordComponentBuilder.Nested<U> {
		private final U upstream;

		public Nested(String name, ClassType type, String signature, U upstream) {
			this.upstream = upstream;
			this.name = name;
			this.type = type;
			this.signature = signature;
		}

		@Override
		public @Nullable AnnotationBuilder.Nested<RecordComponentBuilder.Nested<U>> visibleRuntimeAnnotation(InstanceType type) {
			//noinspection unchecked
			return (AnnotationBuilder.Nested<RecordComponentBuilder.Nested<U>>) super.visibleRuntimeAnnotation(type);
		}

		@Override
		public @Nullable AnnotationBuilder.Nested<RecordComponentBuilder.Nested<U>> invisibleRuntimeAnnotation(InstanceType type) {
			//noinspection unchecked
			return (AnnotationBuilder.Nested<RecordComponentBuilder.Nested<U>>) super.invisibleRuntimeAnnotation(type);
		}

		@Override
		public U __() {
			return upstream;
		}
	}
}
