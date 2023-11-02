package dev.xdark.blw.classfile;

public sealed interface Named permits Member, MemberIdentifier, Module, RecordComponent {
	String name();
}
