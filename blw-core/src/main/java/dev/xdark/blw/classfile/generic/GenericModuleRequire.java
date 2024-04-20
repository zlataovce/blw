package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.ModuleRequire;

public record GenericModuleRequire(int accessFlags, String module, String version) implements ModuleRequire {


}
