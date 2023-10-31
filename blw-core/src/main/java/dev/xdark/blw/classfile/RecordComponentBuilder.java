package dev.xdark.blw.classfile;

import dev.xdark.blw.annotation.AnnotationBuilder;
import dev.xdark.blw.classfile.generic.GenericRecordComponentBuilder;
import dev.xdark.blw.type.ClassType;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.util.Builder;
import org.jetbrains.annotations.Nullable;

public sealed interface RecordComponentBuilder extends AnnotatedBuilder permits RecordComponentBuilder.Root, RecordComponentBuilder.Nested {
	non-sealed interface Root extends RecordComponentBuilder, Builder.Root<RecordComponent> {
		RecordComponentBuilder name(String name);

		RecordComponentBuilder type(ClassType type);

		RecordComponentBuilder signature(String signature);

		@Override
		@Nullable AnnotationBuilder.Nested<RecordComponentBuilder.Root> visibleRuntimeAnnotation(InstanceType type);

		@Override
		@Nullable AnnotationBuilder.Nested<RecordComponentBuilder.Root> invisibleRuntimeAnnotation(InstanceType type);
	}

	non-sealed interface Nested<U extends Builder> extends RecordComponentBuilder, Builder.Nested<U> {
		@Override
		@Nullable AnnotationBuilder.Nested<RecordComponentBuilder.Nested<U>> visibleRuntimeAnnotation(InstanceType type);

		@Override
		@Nullable AnnotationBuilder.Nested<RecordComponentBuilder.Nested<U>> invisibleRuntimeAnnotation(InstanceType type);
	}

	static RecordComponentBuilder.Root builder() {
		return new GenericRecordComponentBuilder.Root();
	}
}
