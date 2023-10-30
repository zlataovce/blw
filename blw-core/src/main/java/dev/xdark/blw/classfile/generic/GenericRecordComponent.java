package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.annotation.Annotation;
import dev.xdark.blw.classfile.RecordComponent;
import dev.xdark.blw.type.Type;

import java.util.List;

public record GenericRecordComponent(String name, String signature, Type type,
									 List<Annotation> visibleRuntimeAnnotations,
									 List<Annotation> invisibleRuntimeAnnotations) implements RecordComponent {}
