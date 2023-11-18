package dev.xdark.blw.code.generic;

import dev.xdark.blw.code.CodeElement;
import dev.xdark.blw.code.CodeListBuilder;
import dev.xdark.blw.code.Instruction;
import dev.xdark.blw.code.Label;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GenericCodeListBuilder implements CodeListBuilder {
	protected final List<CodeElement> elements = new ArrayList<>();

	@Override
	public @NotNull CodeListBuilder addInstruction(@NotNull Instruction instruction) {
		elements.add(instruction);
		return this;
	}

	@Override
	public @NotNull CodeListBuilder addInstruction(int index, @NotNull Instruction instruction) {
		elements.add(index, instruction);
		return updateIndicesAfter(index);
	}

	@Override
	public @NotNull CodeListBuilder addLabel(@NotNull Label label) {
		List<CodeElement> elements = this.elements;
		label.setIndex(elements.size());
		elements.add(label);
		return this;
	}

	@Override
	public @NotNull CodeListBuilder addLabel(int index, @NotNull Label label) {
		List<CodeElement> elements = this.elements;
		label.setIndex(index);
		elements.add(index, label);
		return updateIndicesAfter(index);
	}

	@Override
	public @NotNull List<CodeElement> getElements() {
		return elements;
	}

	@Override
	public @NotNull CodeListBuilder setElements(@NotNull List<CodeElement> elements) {
		this.elements.clear();
		this.elements.addAll(elements);
		return this;
	}

	@Override
	public List<CodeElement> build() {
		return new CodeElementList(elements);
	}

	@NotNull
	private CodeListBuilder updateIndicesAfter(int index) {
		ListIterator<CodeElement> it = elements.listIterator(index + 1);
		while (it.hasNext()) {
			if (it.next() instanceof Label forwardLabel) {
				forwardLabel.setIndex(it.previousIndex());
			}
		}
		return this;
	}
}
