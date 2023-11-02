package dev.xdark.blw.classfile;

import dev.xdark.blw.classfile.attribute.InnerClass;
import dev.xdark.blw.constantpool.ConstantPool;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.version.JavaVersion;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public non-sealed interface ClassFileView extends Accessible, Annotated, Signed, Typed<InstanceType> {

	@Nullable
	ConstantPool constantPool();

	@Nullable
	InstanceType superClass();

	List<InstanceType> interfaces();

	JavaVersion version();

	List<Method> methods();

	List<Field> fields();

	List<RecordComponent> recordComponents();

	List<InnerClass> innerClasses();

	@Nullable
	String outerClass();

	@Nullable
	String outerMethodName();

	@Nullable
	String outerMethodDescriptor();

	@Nullable
	List<InstanceType> permittedSubclasses();

	@Nullable
	InstanceType nestHost();

	@Nullable
	List<InstanceType> nestMembers();

	@Nullable
	String sourceFile();

	@Nullable
	String sourceDebug();

	@Nullable
	List<Module> modules();
}
