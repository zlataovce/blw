package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.ModuleOpen;

import java.util.List;

public class GenericModuleOpen implements ModuleOpen {
	protected final int accessFlags;
	protected final String packageName;
	protected final List<String> modules;

	public GenericModuleOpen(int accessFlags, String packageName, List<String> modules) {
		this.accessFlags = accessFlags;
		this.packageName = packageName;
		this.modules = modules;
	}

	@Override
	public int accessFlags() {
		return accessFlags;
	}

	@Override
	public String packageName() {
		return packageName;
	}

	@Override
	public List<String> modules() {
		return modules;
	}
}
