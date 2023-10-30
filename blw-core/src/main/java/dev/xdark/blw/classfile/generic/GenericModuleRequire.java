package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.ModuleRequire;

public class GenericModuleRequire implements ModuleRequire {
	private final int accessFlags;
	private final String module;
	private final String version;

	public GenericModuleRequire(int accessFlags, String module, String version) {
		this.accessFlags = accessFlags;
		this.module = module;
		this.version = version;
	}

	@Override
	public int accessFlags() {
		return accessFlags;
	}

	@Override
	public String module() {
		return module;
	}

	@Override
	public String version() {
		return version;
	}
}
