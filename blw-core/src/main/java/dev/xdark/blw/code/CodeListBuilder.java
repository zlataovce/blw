package dev.xdark.blw.code;

import dev.xdark.blw.util.Builder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface CodeListBuilder extends Builder<List<CodeElement>> {
	@NotNull
	CodeListBuilder addInstruction(@NotNull Instruction instruction);

	@NotNull
	CodeListBuilder addInstruction(int index, @NotNull Instruction instruction);

	@NotNull
	CodeListBuilder addLabel(@NotNull Label label);

	@NotNull
	CodeListBuilder addLabel(int index, @NotNull Label label);

	@Nullable
	default CodeElement getFirstElement() {
		List<CodeElement> elements = getElements();
		if (elements.isEmpty()) return null;
		return elements.get(0);
	}

	@Nullable
	default CodeElement getLastElement() {
		List<CodeElement> elements = getElements();
		if (elements.isEmpty()) return null;
		return elements.get(elements.size() - 1);
	}

	@Nullable
	default Label getFirstLabel() {
		return getElements().stream()
				.filter(e -> e instanceof Label)
				.map(e -> (Label) e)
				.findFirst().orElse(null);
	}

	@Nullable
	default Label getLastLabel() {
		return getElements().stream()
				.filter(e -> e instanceof Label)
				.map(e -> (Label) e)
				.reduce((first, second) -> second)
				.orElse(null);
	}

	default int indexOf(@NotNull CodeElement element) {
		return getElements().indexOf(element);
	}

	@NotNull
	List<CodeElement> getElements();

	@NotNull
	CodeListBuilder setElements(@NotNull List<CodeElement> elements);
}
