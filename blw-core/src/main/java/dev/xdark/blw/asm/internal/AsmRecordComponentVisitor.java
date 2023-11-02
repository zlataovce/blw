package dev.xdark.blw.asm.internal;

import dev.xdark.blw.classfile.RecordComponentBuilder;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.RecordComponentVisitor;

public class AsmRecordComponentVisitor extends RecordComponentVisitor {
	protected final RecordComponentBuilder<?> recordComponent;

	public AsmRecordComponentVisitor(RecordComponentBuilder<?> recordComponent) {
		super(Opcodes.ASM9);
		this.recordComponent = recordComponent;
	}

	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
		return Util.visitAnnotation((RecordComponentBuilder) recordComponent, descriptor, visible);
	}
}
