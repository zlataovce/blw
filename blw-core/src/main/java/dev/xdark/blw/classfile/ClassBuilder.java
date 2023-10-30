package dev.xdark.blw.classfile;

import dev.xdark.blw.annotation.AnnotationBuilder;
import dev.xdark.blw.classfile.attribute.InnerClass;
import dev.xdark.blw.classfile.generic.GenericClassBuilder;
import dev.xdark.blw.constantpool.ConstantPool;
import dev.xdark.blw.type.ClassType;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.type.MethodType;
import dev.xdark.blw.util.Builder;
import dev.xdark.blw.version.JavaVersion;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ClassBuilder extends AccessibleBuilder, AnnotatedBuilder, SignedBuilder, Builder.Root<ClassFileView> {

	@Override
	ClassBuilder accessFlags(int accessFlags);

	@Override
	ClassBuilder signature(@Nullable String signature);

	@Override
	@Nullable AnnotationBuilder.Nested<ClassBuilder> visibleRuntimeAnnotation(InstanceType type);

	@Override
	@Nullable AnnotationBuilder.Nested<ClassBuilder> invisibleRuntimeAnnotation(InstanceType type);

	ClassBuilder constantPool(@Nullable ConstantPool constantPool);

	ClassBuilder type(InstanceType type);

	ClassBuilder superClass(@Nullable InstanceType superClass);

	ClassBuilder interfaces(List<InstanceType> interfaces);

	ClassBuilder version(JavaVersion version);

	@Nullable
	MethodBuilder.Nested<ClassBuilder> method(int accessFlags, String name, MethodType type);

	@Nullable
	FieldBuilder.Nested<ClassBuilder> field(int accessFlags, String name, ClassType type);

	@Nullable
	RecordComponentBuilder.Nested<ClassBuilder> recordComponent(String name, ClassType type, String signature);

	ClassBuilder method(MethodBuilder.Root method);

	ClassBuilder field(FieldBuilder.Root field);

	ClassBuilder method(Method method);

	ClassBuilder field(Field field);

	ClassBuilder innerClasses(List<InnerClass> innerClasses);

	ClassBuilder innerClass(InnerClass innerClass);

	ClassBuilder outerClass(String owner);

	ClassBuilder outerMethod(String owner, String name, String descriptor);

	ClassBuilder permittedSubclass(InstanceType permittedSubclass);

	ClassBuilder nestHost(@Nullable InstanceType nestHost);

	ClassBuilder nestMember(@Nullable InstanceType nestMember);

	ClassBuilder sourceFile(@Nullable String sourceFile);

	ClassBuilder sourceDebug(@Nullable String sourceDebug);

	static ClassBuilder builder() {
		return new GenericClassBuilder();
	}
}
