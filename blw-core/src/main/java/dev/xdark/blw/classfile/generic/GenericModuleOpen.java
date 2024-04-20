package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.ModuleOpen;

import java.util.List;

public record GenericModuleOpen(int accessFlags, String packageName, List<String> modules) implements ModuleOpen {


}
