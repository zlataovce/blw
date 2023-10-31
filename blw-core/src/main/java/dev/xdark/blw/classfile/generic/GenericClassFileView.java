package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.annotation.Annotation;
import dev.xdark.blw.classfile.ClassFileView;
import dev.xdark.blw.classfile.Field;
import dev.xdark.blw.classfile.Module;
import dev.xdark.blw.classfile.RecordComponent;
import dev.xdark.blw.classfile.attribute.InnerClass;
import dev.xdark.blw.classfile.Method;
import dev.xdark.blw.constantpool.ConstantPool;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.version.JavaVersion;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class GenericClassFileView implements ClassFileView {
	private final JavaVersion version;
	private final ConstantPool pool;
	private final int accessFlags;
	private final InstanceType type;
	private final InstanceType superClass;
	private final String signature;
	private final List<InstanceType> interfaces;
	private final List<Method> methods;
	private final List<Field> fields;
	private final List<RecordComponent> recordComponents;
	private final List<InnerClass> innerClasses;
	private final String outerClass;
	private final String outerMethodName;
	private final String outerMethodDescriptor;
	private final List<InstanceType> permittedSubclasses;
	private final InstanceType nestHost;
	private final List<InstanceType> nestMembers;
	private final String sourceFile, sourceDebug;
	private final List<Annotation> visibleRuntimeAnnotations;
	private final List<Annotation> invisibleRuntimeAnnotations;
	private final List<Module> modules;

	public GenericClassFileView(JavaVersion version, ConstantPool pool, int accessFlags, InstanceType type,
								InstanceType superClass, String signature, List<InstanceType> interfaces,
								List<Method> methods, List<Field> fields, List<RecordComponent> recordComponents,
								List<InnerClass> innerClasses, String outerClass, String outerMethodName, String outerMethodDescriptor,
								List<InstanceType> permittedSubclasses,
								InstanceType nestHost, List<InstanceType> nestMembers, String sourceFile, String sourceDebug,
								List<Annotation> visibleRuntimeAnnotations, List<Annotation> invisibleRuntimeAnnotations,
								List<Module> modules) {
		this.version = version;
		this.pool = pool;
		this.accessFlags = accessFlags;
		this.type = type;
		this.superClass = superClass;
		this.signature = signature;
		this.interfaces = interfaces;
		this.methods = methods;
		this.fields = fields;
		this.recordComponents = recordComponents;
		this.innerClasses = innerClasses;
		this.outerMethodName = outerMethodName;
		this.outerMethodDescriptor = outerMethodDescriptor;
		this.outerClass = outerClass;
		this.permittedSubclasses = permittedSubclasses;
		this.nestHost = nestHost;
		this.nestMembers = nestMembers;
		this.sourceFile = sourceFile;
		this.sourceDebug = sourceDebug;
		this.visibleRuntimeAnnotations = visibleRuntimeAnnotations;
		this.invisibleRuntimeAnnotations = invisibleRuntimeAnnotations;
		this.modules = modules;
	}

	@Override
	public int accessFlags() {
		return accessFlags;
	}

	@Override
	public List<Annotation> visibleRuntimeAnnotations() {
		return visibleRuntimeAnnotations;
	}

	@Override
	public List<Annotation> invisibleRuntimeAnnotations() {
		return invisibleRuntimeAnnotations;
	}

	@Override
	public @Nullable ConstantPool constantPool() {
		return pool;
	}

	@Override
	public InstanceType type() {
		return type;
	}

	@Override
	public @Nullable InstanceType superClass() {
		return superClass;
	}

	@Override
	public List<InstanceType> interfaces() {
		return interfaces;
	}

	@Override
	public JavaVersion version() {
		return version;
	}

	@Override
	public List<Method> methods() {
		return methods;
	}

	@Override
	public List<Field> fields() {
		return fields;
	}

	@Override
	public List<RecordComponent> recordComponents() {
		return recordComponents;
	}

	@Override
	public List<InnerClass> innerClasses() {
		return innerClasses;
	}

	@Override
	public @Nullable String outerClass() {
		return outerClass;
	}

	@Override
	public @Nullable String outerMethodName() {
		return outerMethodName;
	}

	@Override
	public @Nullable String outerMethodDescriptor() {
		return outerMethodDescriptor;
	}

	@Override
	public @Nullable List<InstanceType> permittedSubclasses() {
		return permittedSubclasses;
	}

	@Override
	public @Nullable InstanceType nestHost() {
		return nestHost;
	}

	@Override
	public @Nullable List<InstanceType> nestMembers() {
		return nestMembers;
	}

	@Override
	public @Nullable String sourceFile() {
		return sourceFile;
	}

	@Override
	public @Nullable String sourceDebug() {
		return sourceDebug;
	}

	@Override
	public @Nullable String signature() {
		return signature;
	}

	@Override
	public @Nullable List<Module> modules() {
		return modules;
	}
}
