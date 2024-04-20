package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.classfile.ModuleProvide;

import java.util.List;

public record GenericModuleProvide(String service, List<String> providers) implements ModuleProvide {


}
