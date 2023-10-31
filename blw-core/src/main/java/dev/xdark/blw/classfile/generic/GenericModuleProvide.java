package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.ModuleProvide;

import java.util.List;

public class GenericModuleProvide implements ModuleProvide {
	private final String service;
	private final List<String> providers;

	public GenericModuleProvide(String service, List<String> providers) {
		this.providers = providers;
		this.service = service;
	}

	@Override
	public List<String> providers() {
		return providers;
	}

	@Override
	public String service() {
		return service;
	}
}
