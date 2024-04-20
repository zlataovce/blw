package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.annotation.Annotation;
import dev.xdark.blw.classfile.RecordComponent;
import dev.xdark.blw.type.ClassType;

import java.util.List;

public record GenericRecordComponent(String name, String signature, ClassType type,
                                     List<Annotation> visibleRuntimeAnnotations,
                                     List<Annotation> invisibleRuntimeAnnotations) implements RecordComponent {


}