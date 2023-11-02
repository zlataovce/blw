package dev.xdark.blw.asm.internal;

import dev.xdark.blw.classfile.FieldBuilder;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

public class AsmFieldVisitor extends FieldVisitor {
	protected final FieldBuilder<?, ?> field;

	public AsmFieldVisitor(FieldBuilder<?, ?> field) {
		super(Opcodes.ASM9);
		this.field = field;
	}

	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
		return Util.visitAnnotation((FieldBuilder) field, descriptor, visible);
	}
}
