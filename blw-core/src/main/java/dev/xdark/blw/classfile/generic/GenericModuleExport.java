package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.ModuleExport;

import java.util.List;

public class GenericModuleExport implements ModuleExport {
	private final int accessFlags;
	private final List<String> modules;
	private final String packageName;

	public GenericModuleExport(int accessFlags, List<String> modules, String packageName) {
		this.accessFlags = accessFlags;
		this.modules = modules;
		this.packageName = packageName;
	}

	@Override
	public int accessFlags() {
		return accessFlags;
	}

	@Override
	public List<String> modules() {
		return modules;
	}

	@Override
	public String packageName() {
		return packageName;
	}
}
