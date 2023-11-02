package dev.xdark.blw.code.generic;

import dev.xdark.blw.code.Code;
import dev.xdark.blw.code.CodeBuilder;
import dev.xdark.blw.code.CodeListBuilder;
import dev.xdark.blw.code.TryCatchBlock;
import dev.xdark.blw.code.attribute.Local;
import dev.xdark.blw.util.Split;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericCodeBuilder implements CodeBuilder<GenericCodeBuilder> {
	protected int maxStack, maxLocals;
	protected List<TryCatchBlock> tryCatchBlocks = List.of();
	protected CodeListBuilder content;
	protected List<Local> localVariables = List.of();

	@Override
	public int maxStack() {
		return maxStack;
	}

	@Override
	public GenericCodeBuilder maxStack(int maxStack) {
		this.maxStack = maxStack;
		return this;
	}

	@Override
	public int maxLocals() {
		return maxLocals;
	}

	@Override
	public GenericCodeBuilder maxLocals(int maxLocals) {
		this.maxLocals = maxLocals;
		return this;
	}

	@Override
	public List<TryCatchBlock> tryCatchBlocks() {
		return tryCatchBlocks;
	}

	@Override
	public GenericCodeBuilder tryCatchBlocks(List<TryCatchBlock> tryCatchBlocks) {
		this.tryCatchBlocks = tryCatchBlocks;
		return this;
	}

	@Override
	public GenericCodeBuilder tryCatchBlock(TryCatchBlock tryCatchBlock) {
		List<TryCatchBlock> tcbs = tryCatchBlocks;
		if (tcbs.isEmpty()) {
			tcbs = new ArrayList<>();
			tryCatchBlocks = tcbs;
		}
		tcbs.add(tryCatchBlock);
		return this;
	}

	@Override
	public List<Local> localVariables() {
		return localVariables;
	}

	@Override
	public GenericCodeBuilder localVariables(List<Local> localVariables) {
		this.localVariables = localVariables;
		return this;
	}

	@Override
	public GenericCodeBuilder localVariable(Local local) {
		List<Local> locals = localVariables;
		if (locals.isEmpty()) {
			locals = new ArrayList<>();
			localVariables = locals;
		}
		locals.add(local);
		return this;
	}

	@Override
	public Split<GenericCodeBuilder, CodeListBuilder> codeList() {
		CodeListBuilder content = this.content;
		if (content == null) {
			content = new GenericCodeListBuilder();
			this.content = content;
		}
		return Split.of(this, content);
	}

	@Override
	public Code build() {
		return new GenericCode(
				maxStack,
				maxLocals,
				content == null ? Collections.emptyList() : content.build(),
				tryCatchBlocks,
				localVariables);
	}
}
