package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.annotation.Annotation;
import dev.xdark.blw.annotation.AnnotationBuilder;
import dev.xdark.blw.classfile.Member;
import dev.xdark.blw.classfile.MemberBuilder;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.type.Type;
import dev.xdark.blw.util.Builder;
import dev.xdark.blw.util.LazyList;
import dev.xdark.blw.util.Split;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class GenericMemberBuilder<T extends Type, M extends Member<T>, B extends GenericMemberBuilder<T, M, B>>
		implements MemberBuilder<T, M, B> {
	protected final List<AnnotationBuilder<?>> visibleRuntimeAnnotations = LazyList.arrayList();
	protected final List<AnnotationBuilder<?>> invisibleRuntimeAnnotation = LazyList.arrayList();
	protected T type;
	protected int accessFlags;
	protected String name;
	protected String signature;

	@Override
	@SuppressWarnings("unchecked")
	public B accessFlags(int accessFlags) {
		this.accessFlags = accessFlags;
		return (B) this;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	@SuppressWarnings("unchecked")
	public B name(String name) {
		this.name = name;
		return (B) this;
	}

	@Override
	public @Nullable String signature() {
		return signature;
	}

	@Override
	public T type() {
		return type;
	}

	@Override
	@SuppressWarnings("unchecked")
	public B type(T type) {
		this.type = type;
		return (B) this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public B signature(@Nullable String signature) {
		this.signature = signature;
		return (B) this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <A extends AnnotationBuilder<A>> Split<B, A> putVisibleRuntimeAnnotation(InstanceType type) {
		A anno = AnnotationBuilder.newAnnotationBuilder(type);
		visibleRuntimeAnnotations.add(anno);
		return Split.of((B) this, anno);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <A extends AnnotationBuilder<A>> Split<B, A> putInvisibleRuntimeAnnotation(InstanceType type) {
		A anno = AnnotationBuilder.newAnnotationBuilder(type);
		invisibleRuntimeAnnotation.add(anno);
		return Split.of((B) this, anno);
	}

	@NotNull
	protected final List<Annotation> visibleRuntimeAnnotations() {
		return visibleRuntimeAnnotations.stream().map(Builder::build).toList();
	}

	@NotNull
	protected final List<Annotation> invisibleRuntimeAnnotation() {
		return invisibleRuntimeAnnotation.stream().map(Builder::build).toList();
	}
}
