package dev.xdark.blw.code;

import dev.xdark.blw.classfile.Self;
import dev.xdark.blw.util.Split;
import dev.xdark.blw.code.attribute.Local;
import dev.xdark.blw.util.Builder;

import java.util.List;

public interface CodeBuilder<B extends CodeBuilder<B>> extends Self<B>, Builder<Code> {
	int maxStack();

	B maxStack(int maxStack);

	int maxLocals();

	B maxLocals(int maxLocals);

	List<TryCatchBlock> tryCatchBlocks();

	B tryCatchBlocks(List<TryCatchBlock> tryCatchBlocks);

	B tryCatchBlock(TryCatchBlock tryCatchBlock);

	List<Local> localVariables();

	B localVariables(List<Local> locals);

	B localVariable(Local local);

	Split<B, CodeListBuilder> codeList();
}
