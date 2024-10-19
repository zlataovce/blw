package dev.xdark.blw.cafedude;

import dev.xdark.blw.BytecodeLibrary;
import dev.xdark.blw.cafedude.internal.InternalCafeDudeLibrary;
import dev.xdark.blw.classfile.ClassBuilder;
import dev.xdark.blw.classfile.ClassFileView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CafeDudeBytecodeLibrary implements BytecodeLibrary {
    protected final BytecodeLibrary inner;

    public CafeDudeBytecodeLibrary() {
        inner = new InternalCafeDudeLibrary();
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
