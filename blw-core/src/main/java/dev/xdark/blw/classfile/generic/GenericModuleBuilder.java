package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.Module;
import dev.xdark.blw.classfile.*;
import dev.xdark.blw.util.Builder;

import java.util.ArrayList;
import java.util.List;

public sealed abstract class GenericModuleBuilder implements ModuleBuilder.Root permits
		GenericModuleBuilder.Root, GenericModuleBuilder.Nested {
	private final List<String> packages = new ArrayList<>();
	private final List<ModuleRequire> requires = new ArrayList<>();
	private final List<ModuleExport> exports = new ArrayList<>();
	private final List<ModuleOpen> opens = new ArrayList<>();
	private final List<ModuleProvide> provides = new ArrayList<>();
	private final List<String> uses = new ArrayList<>();
	protected String name;
	protected int accessFlags;
	protected String version;
	private String mainClass;

	@Override
	public ModuleBuilder mainClass(String mainClass) {
		this.mainClass = mainClass;
		return this;
	}

	@Override
	public ModuleBuilder packagee(String packageName) {
		packages.add(packageName);
		return this;
	}

	@Override
	public ModuleBuilder require(ModuleRequire require) {
		requires.add(require);
		return this;
	}

	@Override
	public ModuleBuilder export(ModuleExport export) {
		exports.add(export);
		return this;
	}

	@Override
	public ModuleBuilder open(ModuleOpen open) {
		opens.add(open);
		return this;
	}

	@Override
	public ModuleBuilder provide(ModuleProvide provide) {
		provides.add(provide);
		return this;
	}

	@Override
	public ModuleBuilder use(String use) {
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

	public static final class Root extends GenericModuleBuilder implements ModuleBuilder.Root {
	}

	public static final class Nested<U extends Builder> extends GenericModuleBuilder implements ModuleBuilder.Nested<U> {
		private final U upstream;

		public Nested(String name, int accessFlags, String version, U upstream) {
			this.upstream = upstream;
			this.name = name;
			this.accessFlags = accessFlags;
			this.version = version;
		}

		@Override
		public U __() {
			return upstream;
		}
	}
}
