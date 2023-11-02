package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.Module;
import dev.xdark.blw.classfile.*;

import java.util.ArrayList;
import java.util.List;

public class GenericModuleBuilder implements ModuleBuilder<GenericModuleBuilder> {
	protected final List<String> packages = new ArrayList<>();
	protected final List<ModuleRequire> requires = new ArrayList<>();
	protected final List<ModuleExport> exports = new ArrayList<>();
	protected final List<ModuleOpen> opens = new ArrayList<>();
	protected final List<ModuleProvide> provides = new ArrayList<>();
	protected final List<String> uses = new ArrayList<>();
	protected String name;
	protected int accessFlags;
	protected String version;
	protected String mainClass;

	public GenericModuleBuilder(String name, int access, String version) {
		this.name = name;
		this.accessFlags = access;
		this.version = version;
	}

	@Override
	public GenericModuleBuilder mainClass(String mainClass) {
		this.mainClass = mainClass;
		return this;
	}

	@Override
	public GenericModuleBuilder packagee(String packageName) {
		packages.add(packageName);
		return this;
	}

	@Override
	public GenericModuleBuilder require(ModuleRequire require) {
		requires.add(require);
		return this;
	}

	@Override
	public GenericModuleBuilder export(ModuleExport export) {
		exports.add(export);
		return this;
	}

	@Override
	public GenericModuleBuilder open(ModuleOpen open) {
		opens.add(open);
		return this;
	}

	@Override
	public GenericModuleBuilder provide(ModuleProvide provide) {
		provides.add(provide);
		return this;
	}

	@Override
	public GenericModuleBuilder use(String use) {
		uses.add(use);
		return this;
	}

	@Override
	public Module build() {
		return new GenericModule(name, accessFlags, version, mainClass, packages, requires, exports, opens, provides, uses);
	}

	@Override
	public Module reflectAs() {
		return build();
	}
}
