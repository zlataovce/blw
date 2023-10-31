package dev.xdark.blw.asm.internal;

import dev.xdark.blw.classfile.RecordComponentBuilder;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.RecordComponentVisitor;

final class AsmRecordComponentVisitor extends RecordComponentVisitor {
	private final RecordComponentBuilder recordComponent;

	AsmRecordComponentVisitor(RecordComponentBuilder recordComponent) {
		super(Opcodes.ASM9);
		this.recordComponent = recordComponent;
	}

	@Override
	public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
		return Util.visitAnnotation(recordComponent, descriptor, visible);
	}
}
