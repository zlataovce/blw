package dev.xdark.blw.classfile;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public non-sealed interface Module extends Accessible, Named {
	/**
	 * @return Version of this module.
	 */
	@Nullable
	String version();

	/**
	 * @return Internal name of the main class of this module.
	 */
	@Nullable
	String mainClass();

	/**
	 * @return Internal names of packages declared by this module.
	 */
	@Nullable
	List<String> packages();

	/**
	 * @return Dependencies of this module.
	 */
	@Nullable
	List<ModuleRequire> requires();

	/**
	 * @return Packages exported by this module.
	 */
	@Nullable
	List<ModuleExport> exports();

	/**
	 * @return Packages opened by this module.
	 */
	@Nullable
	List<ModuleOpen> opens();

	/**
	 * @return Services provided by this module.
	 */
	@Nullable
	List<ModuleProvide> provides();

	/**
	 * @return Internal names of the services used by this module.
	 */
	@Nullable
	List<String> uses();
}
