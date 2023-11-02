package dev.xdark.blw.classfile;

import dev.xdark.blw.classfile.generic.GenericModuleBuilder;
import dev.xdark.blw.util.Builder;

public sealed interface ModuleBuilder permits ModuleBuilder.Root, ModuleBuilder.Nested {
	ModuleBuilder mainClass(String mainClass);

	ModuleBuilder packagee(String packageName);

	ModuleBuilder require(ModuleRequire require);

	ModuleBuilder export(ModuleExport export);

	ModuleBuilder open(ModuleOpen open);

	ModuleBuilder provide(ModuleProvide provide);

	ModuleBuilder use(String use);

	non-sealed interface Root extends ModuleBuilder, Builder.Root<Module> {
		@Override
		Module build();

		@Override
		default Module reflectAs() {
			return build();
		}
	}

	non-sealed interface Nested<U extends Builder> extends ModuleBuilder, Builder.Nested<U> {
	}

	static ModuleBuilder.Root builder() {
		return new GenericModuleBuilder.Root();
	}

	static <U extends Builder> ModuleBuilder.Nested<U> builder(String name, int accessFlags, String version, U upstream) {
		return new GenericModuleBuilder.Nested<>(name, accessFlags, version, upstream);
	}
}
