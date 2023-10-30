package dev.xdark.blw.classfile;

import java.util.List;

public interface ModuleProvide {
	/**
	 * @return Internal names of the implementations of the service. Must be at least one value provided.
	 */
	List<String> providers();

	/**
	 * @return Internal name of the service class.
	 */
	String service();
}
