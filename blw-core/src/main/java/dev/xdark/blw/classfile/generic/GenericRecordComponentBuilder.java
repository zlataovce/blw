package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.annotation.Annotation;
import dev.xdark.blw.annotation.AnnotationBuilder;
import dev.xdark.blw.classfile.RecordComponentBuilder;
import dev.xdark.blw.type.ClassType;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.util.Builder;
import dev.xdark.blw.util.LazyList;
import dev.xdark.blw.util.Split;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GenericRecordComponentBuilder implements RecordComponentBuilder<GenericRecordComponentBuilder> {
	protected final List<AnnotationBuilder<?>> visibleRuntimeAnnotations = LazyList.arrayList();
	protected final List<AnnotationBuilder<?>> invisibleRuntimeAnnotations = LazyList.arrayList();
	protected String name;
	protected ClassType type;
	protected String signature;

	public GenericRecordComponentBuilder(String name, ClassType type, String signature) {
		this.name = name;
		this.type = type;
		this.signature = signature;
	}

	@Override
	public GenericRecordComponent build() {
		return new GenericRecordComponent(name, signature, type, visibleRuntimeAnnotations(), invisibleRuntimeAnnotation());
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public GenericRecordComponentBuilder name(String name) {
		this.name = name;
		return this;
	}

	@Override
	public ClassType type() {
		return type;
	}

	@Override
	public GenericRecordComponentBuilder type(ClassType type) {
		this.type = type;
		return this;
	}

	@Override
	public @Nullable String signature() {
		return signature;
	}

	@Override
	public GenericRecordComponentBuilder signature(@Nullable String signature) {
		this.signature = signature;
		return this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <Ab extends AnnotationBuilder<Ab>> Split<GenericRecordComponentBuilder, Ab> putVisibleRuntimeAnnotation(InstanceType type) {
		var builder = AnnotationBuilder.newAnnotationBuilder(type);
		visibleRuntimeAnnotations.add(builder);
		return (Split<GenericRecordComponentBuilder, Ab>) Split.of(this, builder);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <Ab extends AnnotationBuilder<Ab>> Split<GenericRecordComponentBuilder, Ab> putInvisibleRuntimeAnnotation(InstanceType type) {
		var builder = AnnotationBuilder.newAnnotationBuilder(type);
		invisibleRuntimeAnnotations.add(builder);
		return (Split<GenericRecordComponentBuilder, Ab>) Split.of(this, builder);
	}

	@NotNull
	protected final List<Annotation> visibleRuntimeAnnotations() {
		return visibleRuntimeAnnotations.stream().map(Builder::build).toList();
	}

	@NotNull
	protected final List<Annotation> invisibleRuntimeAnnotation() {
		return invisibleRuntimeAnnotations.stream().map(Builder::build).toList();
	}
}
