package dev.xdark.blw.classfile;

import dev.xdark.blw.util.Builder;

public interface ModuleBuilder<B extends ModuleBuilder<B>>
		extends Self<B>, Builder<Module> {
	B mainClass(String mainClass);

	B packagee(String packageName);

	B require(ModuleRequire require);

	B export(ModuleExport export);

	B open(ModuleOpen open);

	B provide(ModuleProvide provide);

	B use(String use);
}
