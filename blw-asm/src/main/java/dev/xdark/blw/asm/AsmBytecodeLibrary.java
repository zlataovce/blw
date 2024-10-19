package dev.xdark.blw.asm;

import dev.xdark.blw.BytecodeLibrary;
import dev.xdark.blw.asm.internal.InternalAsmLibrary;
import dev.xdark.blw.classfile.ClassBuilder;
import dev.xdark.blw.classfile.ClassFileView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AsmBytecodeLibrary implements BytecodeLibrary {
	protected final BytecodeLibrary inner;

	public AsmBytecodeLibrary(ClassWriterProvider classWriterProvider) {
		inner = new InternalAsmLibrary(classWriterProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void read(InputStream in, ClassBuilder classBuilder) throws IOException {
		inner.read(in, classBuilder);
	}

	@Override
	public void write(ClassFileView classFileView, OutputStream os) throws IOException {
		inner.write(classFileView, os);
	}
}
