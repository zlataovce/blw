package dev.xdark.blw.classfile;

import java.util.List;

public interface ModuleOpen extends Accessible {
	/**
	 * @return Internal name of the opened package.
	 */
	String packageName();

	/**
	 * @return Fully qualified names of modules that can use deep reflection to the classes of the opened modules.
	 */
	List<String> modules();
}
