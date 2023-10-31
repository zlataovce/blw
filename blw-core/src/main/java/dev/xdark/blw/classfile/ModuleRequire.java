package dev.xdark.blw.classfile;

import org.jetbrains.annotations.Nullable;

public interface ModuleRequire extends Accessible {
	/**
	 * @return Fully qualified names of the dependence.
	 */
	String module();

	/**
	 * @return Version at compile time.
	 */
	@Nullable
	String version();
}
