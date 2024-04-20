package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.*;
import dev.xdark.blw.classfile.Module;

import java.util.List;

public record GenericModule(String name, int accessFlags, String version, String mainClass, List<String> packages,
                            List<ModuleRequire> requires, List<ModuleExport> exports, List<ModuleOpen> opens,
                            List<ModuleProvide> provides, List<String> uses) implements Module {

}
