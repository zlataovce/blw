package dev.xdark.blw.asm.internal;

import dev.xdark.blw.classfile.ModuleBuilder;
import dev.xdark.blw.classfile.generic.GenericModuleExport;
import dev.xdark.blw.classfile.generic.GenericModuleOpen;
import dev.xdark.blw.classfile.generic.GenericModuleProvide;
import dev.xdark.blw.classfile.generic.GenericModuleRequire;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Arrays;

public class AsmModuleVisitor extends ModuleVisitor {
	private final ModuleBuilder module;

	protected AsmModuleVisitor(ModuleBuilder module) {
		super(Opcodes.ASM9);
		this.module = module;
	}

	@Override
	public void visitMainClass(String mainClass) {
		module.mainClass(mainClass);
	}

	@Override
	public void visitPackage(String packaze) {
		module.packagee(packaze);
	}

	@Override
	public void visitRequire(String moduleName, int access, String version) {
		module.require(new GenericModuleRequire(access, moduleName, version));
	}

	@Override
	public void visitExport(String packaze, int access, String... modules) {
		module.export(new GenericModuleExport(access, Arrays.asList(modules), packaze));
	}

	@Override
	public void visitOpen(String packaze, int access, String... modules) {
		module.open(new GenericModuleOpen(access, packaze, Arrays.asList(modules)));
	}

	@Override
	public void visitUse(String service) {
		module.use(service);
	}

	@Override
	public void visitProvide(String service, String... providers) {
		module.provide(new GenericModuleProvide(service, Arrays.asList(providers)));
	}
}
