package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.annotation.Annotation;
import dev.xdark.blw.classfile.RecordComponent;
import dev.xdark.blw.type.ClassType;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class GenericRecordComponent implements RecordComponent {
	protected final String name;
	protected final String signature;
	protected final ClassType type;
	protected final List<Annotation> visibleRuntimeAnnotations;
	protected final List<Annotation> invisibleRuntimeAnnotations;

	public GenericRecordComponent(String name, String signature, ClassType type,
								  List<Annotation> visibleRuntimeAnnotations, List<Annotation> invisibleRuntimeAnnotations) {
		this.name = name;
		this.signature = signature;
		this.type = type;
		this.visibleRuntimeAnnotations = visibleRuntimeAnnotations;
		this.invisibleRuntimeAnnotations = invisibleRuntimeAnnotations;
	}


	@Override
	public String name() {
		return name;
	}

	@Override
	public ClassType type() {
		return type;
	}

	@Override
	public @Nullable String signature() {
		return signature;
	}

	@Override
	public List<Annotation> visibleRuntimeAnnotations() {
		return visibleRuntimeAnnotations;
	}

	@Override
	public List<Annotation> invisibleRuntimeAnnotations() {
		return invisibleRuntimeAnnotations;
	}
}