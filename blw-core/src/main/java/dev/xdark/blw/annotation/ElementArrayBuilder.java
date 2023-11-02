package dev.xdark.blw.annotation;

import dev.xdark.blw.annotation.generic.GenericArrayBuilder;
import dev.xdark.blw.classfile.Self;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.util.Builder;
import dev.xdark.blw.util.Split;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ElementArrayBuilder<B extends ElementArrayBuilder<B>>
		extends Self<B>, Builder<ElementArray> {

	B element(@NotNull Element element);

	B element(@NotNull Builder<? extends Element> element);

	B elements(@NotNull List<Element> elements);

	default B elements(Element... elements) {
		return elements(List.of(elements));
	}

	@SuppressWarnings("unchecked")
	default <A extends AnnotationBuilder<A>>
	Split<B, A> annotation(InstanceType type) {
		A builder = AnnotationBuilder.newAnnotationBuilder(type);
		element(builder);
		return Split.of((B) this, builder);
	}

	@SuppressWarnings("unchecked")
	default <A extends ElementArrayBuilder<A>>
	Split<B, A> array() {
		A builder = (A) new GenericArrayBuilder();
		element(builder);
		return Split.of((B) this, builder);
	}
}
