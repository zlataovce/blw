package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.ModuleExport;

import java.util.List;

public record GenericModuleExport(int accessFlags, List<String> modules, String packageName) implements ModuleExport {


}
