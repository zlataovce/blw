package dev.xdark.blw.cafedude.internal;

import dev.xdark.blw.BytecodeLibrary;
import dev.xdark.blw.classfile.ClassBuilder;
import dev.xdark.blw.classfile.ClassFileView;
import dev.xdark.blw.constant.*;
import dev.xdark.blw.constantpool.*;
import dev.xdark.blw.type.ConstantDynamic;
import dev.xdark.blw.type.InvokeDynamic;
import dev.xdark.blw.type.Types;
import dev.xdark.blw.version.JavaVersion;
import software.coley.cafedude.InvalidClassException;
import software.coley.cafedude.classfile.ClassFile;
import software.coley.cafedude.classfile.ConstPool;
import software.coley.cafedude.classfile.constant.*;
import software.coley.cafedude.io.ClassFileReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class InternalCafeDudeLibrary implements BytecodeLibrary {
    @Override
    @SuppressWarnings("rawtypes")
    public void read(InputStream in, ClassBuilder classBuilder) throws IOException {
        ClassFileReader cr = new ClassFileReader();
        try {
            this.read(cr.read(in.readAllBytes()), classBuilder);
        } catch (InvalidClassException e) {
            throw new IOException("Failed to read class", e);
        }
    }

    private void read(ClassFile cf, ClassBuilder<?, ?> classBuilder) {
        classBuilder
                .setConstantPool(this.readPool(cf.getPool()))
                .setVersion(JavaVersion.classVersion(cf.getVersionMajor(), cf.getVersionMinor()));

        // TODO
    }

    private ListConstantPool readPool(ConstPool cp) {
        List<Entry> entries = new ArrayList<>(cp.size());
        for (CpEntry entry : cp) {
            Entry entry0 = switch (entry.getTag()) {
                case Tag.Utf8 -> new EntryUtf8(new OfString(((CpUtf8) entry).getText()));
                case Tag.Integer -> new EntryInteger(new OfInt(((CpInt) entry).getValue()));
                case Tag.Float -> new EntryFloat(new OfFloat(((CpFloat) entry).getValue()));
                case Tag.Long -> new EntryLong(new OfLong(((CpLong) entry).getValue()));
                case Tag.Double -> new EntryDouble(new OfDouble(((CpDouble) entry).getValue()));
                case Tag.Class -> new EntryClass(((CpClass) entry).getName().getIndex());
                case Tag.String -> new EntryString(((CpString) entry).getString().getIndex());
                case Tag.Fieldref -> {
                    CpFieldRef ref = (CpFieldRef) entry;
                    yield new EntryFieldRef(ref.getClassRef().getIndex(), ref.getNameType().getIndex());
                }
                case Tag.Methodref -> {
                    CpMethodRef ref = (CpMethodRef) entry;
                    yield new EntryMethodRef(ref.getClassRef().getIndex(), ref.getNameType().getIndex());
                }
                case Tag.InterfaceMethodref -> {
                    CpInterfaceMethodRef ref = (CpInterfaceMethodRef) entry;
                    yield new EntryInterfaceMethodRef(ref.getClassRef().getIndex(), ref.getNameType().getIndex());
                }
                case Tag.NameAndType -> {
                    CpNameType nameType = (CpNameType) entry;
                    yield new EntryNameAndType(nameType.getName().getIndex(), nameType.getType().getIndex());
                }
                case Tag.MethodHandle -> {
                    CpMethodHandle handle = (CpMethodHandle) entry;
                    yield new EntryMethodHandle(handle.getKind(), handle.getReference().getIndex());
                }
                case Tag.MethodType -> new EntryMethodType(((CpMethodType) entry).getDescriptor().getIndex());
                case Tag.Dynamic -> {
                    CpDynamic cd = (CpDynamic) entry;
                    yield new EntryDynamic(new OfDynamic(new ConstantDynamic(
                            cd.getNameType().getName().getText(),
                            Types.objectTypeFromInternalName(cd.getNameType().getType().getText()),
                            // TODO
                    )));
                }
                case Tag.InvokeDynamic -> {
                    CpInvokeDynamic id = (CpInvokeDynamic) entry;
                    yield new EntryInvokeDynamic(new InvokeDynamic(
                            id.getNameType().getName().getText(),
                            Types.methodType(id.getNameType().getType().getText()),
                            // TODO
                    ));
                }
                case Tag.Module -> new EntryModule(((CpModule) entry).getName().getIndex());
                case Tag.Package -> new EntryPackage(((CpPackage) entry).getPackageName().getIndex());
                default -> throw new IllegalStateException("Unexpected value: " + entry.getTag());
            };

            entries.add(entry0);
        }

        return new ListConstantPool(entries);
    }

    @Override
    public void write(ClassFileView classFileView, OutputStream os) {
    }
}
