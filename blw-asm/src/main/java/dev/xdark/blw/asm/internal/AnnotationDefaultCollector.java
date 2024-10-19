package dev.xdark.blw.asm.internal;

import dev.xdark.blw.annotation.ElementEnum;
import dev.xdark.blw.annotation.generic.GenericAnnotationBuilder;
import dev.xdark.blw.annotation.generic.GenericArrayBuilder;
import dev.xdark.blw.classfile.Method;
import dev.xdark.blw.classfile.MethodBuilder;
import dev.xdark.blw.type.Types;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

public class AnnotationDefaultCollector extends AnnotationVisitor {
	protected final MethodBuilder<?, ?> methodBuilder;

	public AnnotationDefaultCollector(MethodBuilder<?, ?> methodBuilder) {
		super(Opcodes.ASM9);
		this.methodBuilder = methodBuilder;
	}

	@Override
	public void visit(String name, Object value) {
		methodBuilder.annotationDefault(Util.wrapElement(value));
	}

	@Override
	public void visitEnum(String name, String descriptor, String value) {
		methodBuilder.annotationDefault(new ElementEnum(Types.instanceTypeFromDescriptor(descriptor), value));
	}

	@Override
	public AnnotationVisitor visitAnnotation(String name, String descriptor) {
		var annotationBuilder = new GenericAnnotationBuilder(Types.instanceTypeFromDescriptor(descriptor));
		methodBuilder.annotationDefault(annotationBuilder);
		return new AsmAnnotationVisitor(annotationBuilder);
	}

	@Override
	public AnnotationVisitor visitArray(String name) {
		var arrayBuilder = new GenericArrayBuilder();
		methodBuilder.annotationDefault(arrayBuilder);
		return new AsmArrayVisitor(arrayBuilder);
	}
}
