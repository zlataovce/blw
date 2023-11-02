package dev.xdark.blw.classfile;

import dev.xdark.blw.classfile.attribute.InnerClass;
import dev.xdark.blw.classfile.generic.GenericClassBuilder;
import dev.xdark.blw.constantpool.ConstantPool;
import dev.xdark.blw.type.ClassType;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.type.MethodType;
import dev.xdark.blw.util.Reflectable;
import dev.xdark.blw.util.Split;
import dev.xdark.blw.version.JavaVersion;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ClassBuilder<E extends ClassFileView, B extends ClassBuilder<E, B>>
		extends AccessibleBuilder<E, B>, AnnotatedBuilder<E, B>, SignedBuilder<E, B>, TypedBuilder<InstanceType, E, B> {

	ConstantPool getConstantPool();

	B setConstantPool(@Nullable ConstantPool constantPool);

	InstanceType getSuperClass();

	B setSuperClass(@Nullable InstanceType superClass);

	List<InstanceType> getInterfaces();

	B addInterface(InstanceType interfaze);

	B setInterfaces(List<InstanceType> interfaces);

	JavaVersion getVersion();

	B setVersion(JavaVersion version);

	@Nullable
	Reflectable<Field> getField(MemberIdentifier identifier);

	@Nullable
	Reflectable<Method> getMethod(MemberIdentifier identifier);

	@Nullable
	FieldBuilder<Field, ?> getFieldBuilder(MemberIdentifier identifier);

	@Nullable
	MethodBuilder<Method, ?> getMethodBuilder(MemberIdentifier identifier);

	@Nullable
	Reflectable<RecordComponent> getRecordComponent(MemberIdentifier identifier);

	@Nullable
	default Reflectable<Field> getField(String name, String descriptor) {
		return getField(new MemberIdentifier(name, descriptor));
	}

	@Nullable
	default Reflectable<Method> getMethod(String name, String descriptor) {
		return getMethod(new MemberIdentifier(name, descriptor));
	}

	@Nullable
	default FieldBuilder<Field, ?> getFieldBuilder(String name, String descriptor) {
		return getFieldBuilder(new MemberIdentifier(name, descriptor));
	}

	@Nullable
	default MethodBuilder<Method, ?> getMethodBuilder(String name, String descriptor) {
		return getMethodBuilder(new MemberIdentifier(name, descriptor));
	}

	@Nullable
	default Reflectable<RecordComponent> getRecordComponent(String name, String descriptor) {
		return getRecordComponent(new MemberIdentifier(name, descriptor));
	}

	List<Reflectable<Field>> getFields();

	List<Reflectable<Method>> getMethods();


	List<Reflectable<RecordComponent>> getRecordComponents();

	<M extends Method, A extends MethodBuilder<M, A>> Split<B, A> putMethod(int accessFlags, String name, MethodType type);

	<F extends Field, A extends FieldBuilder<F, A>> Split<B, A> putField(int accessFlags, String name, ClassType type);

	<A extends RecordComponentBuilder<A>> Split<B, A> putRecordComponent(String name, ClassType type, String signature);

	<M extends Method, A extends MethodBuilder<M, A>> B putMethod(A method);

	<F extends Field, A extends FieldBuilder<F, A>> B putField(A field);

	B putMethod(Method method);

	B putField(Field field);

	List<InnerClass> getInnerClasses();

	B setInnerClasses(List<InnerClass> innerClasses);

	B addInnerClass(InnerClass innerClass);

	@Nullable
	String getOuterClass();

	@Nullable
	String getOuterMethodName();

	@Nullable
	String getOuterMethodDescriptor();

	B setOuterClass(String owner);

	B setOuterMethod(String owner, String name, String descriptor);

	List<InstanceType> getPermittedSubclasses();

	B addPermittedSubclass(InstanceType permittedSubclass);

	@Nullable
	InstanceType getNestHost();

	B setNestHost(@Nullable InstanceType nestHost);

	List<InstanceType> getNestMembers();

	B addNestMember(@Nullable InstanceType nestMember);

	@Nullable
	String getSourceFile();

	B setSourceFile(@Nullable String sourceFile);

	@Nullable
	String getSourceDebug();

	B setSourceDebug(@Nullable String sourceDebug);

	List<Reflectable<Module>> getModules();

	<A extends ModuleBuilder<A>> Split<B, A> addModule(String name, int access, @Nullable String version);

	@SuppressWarnings("unchecked")
	static <A extends ClassBuilder<? extends ClassFileView, A>> A builder() {
		return (A) new GenericClassBuilder();
	}
}
