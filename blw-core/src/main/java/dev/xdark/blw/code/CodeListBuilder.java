package dev.xdark.blw.code;

import dev.xdark.blw.util.Builder;

import java.util.List;

public interface CodeListBuilder extends Builder<List<CodeElement>> {
	CodeListBuilder element(Instruction instruction);

	CodeListBuilder element(Label label);

	List<CodeElement> elements();

	CodeListBuilder elements(List<CodeElement> elements);
}
