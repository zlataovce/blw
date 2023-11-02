package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.annotation.Annotation;
import dev.xdark.blw.classfile.Member;
import dev.xdark.blw.type.Type;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class GenericMember<T extends Type> implements Member<T> {
	protected final int accessFlags;
	protected final String name;
	protected final String signature;
	protected final List<Annotation> visibleRuntimeAnnotations;
	protected final List<Annotation> invisibleRuntimeAnnotations;

	protected GenericMember(int accessFlags, String name, String signature, List<Annotation> visibleRuntimeAnnotations, List<Annotation> invisibleRuntimeAnnotations) {
		this.accessFlags = accessFlags;
		this.name = name;
		this.signature = signature;
		this.visibleRuntimeAnnotations = visibleRuntimeAnnotations;
		this.invisibleRuntimeAnnotations = invisibleRuntimeAnnotations;
	}

	@Override
	public final int accessFlags() {
		return accessFlags;
	}

	@Override
	public final String name() {
		return name;
	}

	@Override
	public final @Nullable String signature() {
		return signature;
	}

	@Override
	public final List<Annotation> visibleRuntimeAnnotations() {
		return visibleRuntimeAnnotations;
	}

	@Override
	public final List<Annotation> invisibleRuntimeAnnotations() {
		return invisibleRuntimeAnnotations;
	}
}
