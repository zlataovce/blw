package dev.xdark.blw.code.generic;

import dev.xdark.blw.code.CodeElement;
import dev.xdark.blw.code.CodeListBuilder;
import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.Label;

import java.util.ArrayList;
import java.util.List;

public class GenericCodeListBuilder implements CodeListBuilder {
	protected final List<CodeElement> elements = new ArrayList<>();

	@Override
	public CodeListBuilder element(Instruction instruction) {
		elements.add(instruction);
		return this;
	}

	@Override
	public CodeListBuilder element(Label label) {
		List<CodeElement> elements = this.elements;
		label.index(elements.size());
		elements.add(label);
		return this;
	}

	@Override
	public List<CodeElement> build() {
		return new CodeElementList(elements);
	}
}
