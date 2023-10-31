package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.*;
import dev.xdark.blw.classfile.Module;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GenericModule implements Module {
	private final String name;
	private final int accessFlags;
	private final String version;
	private final String mainClass;
	private final List<String> packages;
	private final List<ModuleRequire> requires;
	private final List<ModuleExport> exports;
	private final List<ModuleOpen> opens;
	private final List<ModuleProvide> provides;
	private final List<String> uses;

	public GenericModule(String name, int accessFlags, String version, String mainClass, List<String> packages, List<ModuleRequire> requires,
						 List<ModuleExport> exports, List<ModuleOpen> opens, List<ModuleProvide> provides, List<String> uses) {
		this.name = name;
		this.accessFlags = accessFlags;
		this.version = version;
		this.mainClass = mainClass;
		this.packages = packages;
		this.requires = requires;
		this.exports = exports;
		this.opens = opens;
		this.provides = provides;
		this.uses = uses;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public int accessFlags() {
		return accessFlags;
	}

	@Override
	public @Nullable String version() {
		return version;
	}

	@Override
	public @Nullable String mainClass() {
		return mainClass;
	}

	@Override
	public @Nullable List<String> packages() {
		return packages;
	}

	@Override
	public @Nullable List<ModuleRequire> requires() {
		return requires;
	}

	@Override
	public @Nullable List<ModuleExport> exports() {
		return exports;
	}

	@Override
	public @Nullable List<ModuleOpen> opens() {
		return opens;
	}

	@Override
	public @Nullable List<ModuleProvide> provides() {
		return provides;
	}

	@Override
	public @Nullable List<String> uses() {
		return uses;
	}
}
