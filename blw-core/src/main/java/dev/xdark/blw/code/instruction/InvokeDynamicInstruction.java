package dev.xdark.blw.code.instruction;

import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.JavaOpcodes;
import dev.xdark.blw.constant.Constant;
import dev.xdark.blw.type.MethodHandle;
import dev.xdark.blw.type.Type;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class InvokeDynamicInstruction implements Instruction {
	private final String name;
	private final Type descriptor;
	private final MethodHandle methodHandle;
	private final List<Constant> args;

	public InvokeDynamicInstruction(@NotNull String name, @NotNull  Type descriptor,@NotNull  MethodHandle methodHandle, @NotNull List<Constant> args) {
		this.name = name;
		this.descriptor = descriptor;
		this.methodHandle = methodHandle;
		this.args = args;
	}
	@NotNull
	public String name() {
		return name;
	}
	@NotNull
	public Type type() {
		return descriptor;
	}
	@NotNull
	public MethodHandle bootstrapHandle() {
		return methodHandle;
	}
	@NotNull
	public List<Constant> args() {
		return args;
	}

	@Override
	public int opcode() {
		return JavaOpcodes.INVOKEDYNAMIC;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		InvokeDynamicInstruction that = (InvokeDynamicInstruction) o;

		if (!name.equals(that.name)) return false;
		if (!descriptor.equals(that.descriptor)) return false;
		if (!methodHandle.equals(that.methodHandle)) return false;
		return args.equals(that.args);
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + descriptor.hashCode();
		result = 31 * result + methodHandle.hashCode();
		result = 31 * result + args.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "indy " + name + descriptor + " " + methodHandle + " args = " + args;
	}
}
