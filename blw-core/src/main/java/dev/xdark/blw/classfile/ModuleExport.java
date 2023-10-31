package dev.xdark.blw.classfile;

import java.util.List;

public interface ModuleExport extends Accessible {
	/**
	 * @return Fully qualified names of modules that can access this exported package.
	 */
	List<String> modules();

	/**
	 * @return Internal name format of the exported package.
	 */
	String packageName();
}
