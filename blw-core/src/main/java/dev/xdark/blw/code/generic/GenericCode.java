package dev.xdark.blw.code.generic;

import dev.xdark.blw.code.Code;
import dev.xdark.blw.code.CodeElement;
import dev.xdark.blw.code.CodeWalker;
import dev.xdark.blw.code.Label;
import dev.xdark.blw.code.attribute.Local;
import dev.xdark.blw.code.TryCatchBlock;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record GenericCode(int maxStack, int maxLocals, List<CodeElement> elements, List<TryCatchBlock> tryCatchBlocks,
						  List<Local> localVariables) implements Code {


	@Override
	public CodeWalker walker() {
		List<CodeElement> stream = this.elements;
		return new CodeWalker() {
			CodeElement element;
			int index = -1;

			@Override
			public int index() {
				return index;
			}

			@Override
			public @Nullable CodeElement element() {
				return element;
			}

			@Override
			public void advance() {
				int index = this.index + 1;
				List<CodeElement> s;
				if (index < 0 || index >= (s = stream).size()) {
					element = null;
					return;
				}
				element = s.get(index);
				this.index = index;
			}

			@Override
			public void set(Label label) {
				int index = label.getIndex();
				if (index == Label.UNSET) {
					throw new IllegalStateException("Label index is not set");
				}
				this.index = index - 1;
				element = null;
			}
		};
	}


}
