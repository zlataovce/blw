package dev.xdark.blw.asm.internal;

import dev.xdark.blw.annotation.*;
import dev.xdark.blw.classfile.Annotated;
import dev.xdark.blw.classfile.AnnotatedBuilder;
import dev.xdark.blw.constant.*;
import dev.xdark.blw.type.*;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Handle;

import java.util.List;
import java.util.stream.IntStream;

public final class Util {

	private Util() {
	}

	public static MethodHandle wrapMethodHandle(Handle handle) {
		ObjectType owner = Types.objectTypeFromInternalName(handle.getOwner());
		return new MethodHandle(
				handle.getTag(),
				owner,
				handle.getName(),
				new TypeReader(handle.getDesc()).required(),
				handle.isInterface()
		);
	}

	public static Handle unwrapMethodHandle(MethodHandle mh) {
		return new Handle(
				mh.kind(),
				mh.owner().internalName(),
				mh.name(),
				mh.type().descriptor(),
				mh.isInterface()
		);
	}

	public static ConstantDynamic wrapConstantDynamic(org.objectweb.asm.ConstantDynamic cd) {
		return new ConstantDynamic(
				cd.getName(),
				new TypeReader(cd.getDescriptor()).requireClassType(),
				wrapMethodHandle(cd.getBootstrapMethod()),
				IntStream.range(0, cd.getBootstrapMethodArgumentCount()).mapToObj(Util::wrapConstant).toList()
		);
	}

	public static org.objectweb.asm.ConstantDynamic unwrapConstantDynamic(ConstantDynamic cd) {
		return new org.objectweb.asm.ConstantDynamic(
				cd.name(),
				cd.type().descriptor(),
				unwrapMethodHandle(cd.methodHandle()),
				cd.args().stream().map(Util::unwrapConstant).toArray()
		);
	}

	public static Object unwrapType(Type type) {
		return org.objectweb.asm.Type.getType(type.descriptor());
	}

	public static Constant wrapConstant(Object value) {
		if (value instanceof String s) return new OfString(s);
		if (value instanceof Long l) return new OfLong(l);
		if (value instanceof Double d) return new OfDouble(d);
		if (value instanceof Integer i) return new OfInt(i);
		if (value instanceof Float f) return new OfFloat(f);
		if (value instanceof Handle h) return new OfMethodHandle(wrapMethodHandle(h));
		if (value instanceof org.objectweb.asm.Type t)
			return new OfType(new TypeReader(t.getDescriptor()).required());
		if (value instanceof org.objectweb.asm.ConstantDynamic cd)
			return new OfDynamic(Util.wrapConstantDynamic(cd));
		throw new IllegalArgumentException("Cannot convert " + value + " into library constant");
	}

	public static Object unwrapConstant(Constant constant) {
		if (constant instanceof OfString c) {
			return c.value();
		} else if (constant instanceof OfMethodHandle c) {
			return unwrapMethodHandle(c.value());
		} else if (constant instanceof OfType c) {
			return unwrapType(c.value());
		} else if (constant instanceof OfDynamic c) {
			return unwrapConstantDynamic(c.value());
		} else if (constant instanceof OfLong c) {
			return c.value();
		} else if (constant instanceof OfDouble c) {
			return c.value();
		} else if (constant instanceof OfInt c) {
			return c.value();
		} else if (constant instanceof OfFloat c) {
			return c.value();
		} else {
			throw new IllegalStateException("Unexpected value: " + constant);
		}
	}

	public static Element wrapElement(Object value) {
		if (value instanceof String s) return new ElementString(s);
		if (value instanceof Long l) return new ElementLong(l);
		if (value instanceof Double d) return new ElementDouble(d);
		if (value instanceof Integer i) return new ElementInt(i);
		if (value instanceof Float f) return new ElementFloat(f);
		if (value instanceof Character c) return new ElementChar(c);
		if (value instanceof Short s) return new ElementShort(s);
		if (value instanceof Byte b) return new ElementByte(b);
		if (value instanceof Boolean b) return new ElementBoolean(b);
		if (value instanceof String[] a) return new ElementEnum(
				Types.instanceTypeFromInternalName(a[0]), a[1]
		);
		if (value instanceof List<?> list) return new ElementArray(list.stream().map(Util::wrapElement));
		throw new IllegalArgumentException("Cannot convert " + value + " into annotation element");
	}

	static <E extends Annotated, A extends AnnotatedBuilder<E, A>> AnnotationVisitor visitAnnotation(A annotated, String descriptor, boolean visible) {
		InstanceType type = Types.instanceTypeFromDescriptor(descriptor);
		AnnotationBuilder<?> builder;
		if (visible) {
			builder = annotated.putVisibleRuntimeAnnotation(type).child();
		} else {
			builder = annotated.putInvisibleRuntimeAnnotation(type).child();
		}
		return builder == null ? null : new AsmAnnotationVisitor(builder);
	}
}
