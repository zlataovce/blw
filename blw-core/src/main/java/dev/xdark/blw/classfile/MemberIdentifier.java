package dev.xdark.blw.classfile;

import dev.xdark.blw.type.Type;

public record MemberIdentifier(String name, String descriptor) implements Named {
	public MemberIdentifier(String name, Type type) {
		this(name, type.descriptor());
	}
}
