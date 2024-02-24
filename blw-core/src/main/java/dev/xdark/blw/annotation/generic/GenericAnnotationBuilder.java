package dev.xdark.blw.annotation.generic;

import dev.xdark.blw.annotation.Annotation;
import dev.xdark.blw.annotation.AnnotationBuilder;
import dev.xdark.blw.annotation.Element;
import dev.xdark.blw.annotation.MapAnnotation;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.util.Builder;
import dev.xdark.blw.util.Reflectable;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class GenericAnnotationBuilder implements AnnotationBuilder<GenericAnnotationBuilder> {
	protected final Map<String, Object> elements = new LinkedHashMap<>();
	protected InstanceType type;

	public GenericAnnotationBuilder(InstanceType type) {
		this.type = type;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Annotation build() {
		return new MapAnnotation(type, elements.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> {
			Object value = e.getValue();
			return value instanceof Element element ? element : ((Builder<Element>) value).build();
		}, (m1, m2) -> {
			throw new IllegalStateException("Merge of duplicate annotation value keys not allowed");
		}, LinkedHashMap::new)));
	}

	@Override
	public @NotNull Set<String> elementKeys() {
		return elements.keySet();
	}

	@Override
	@SuppressWarnings("unchecked")
	public @NotNull Map<String, Reflectable<Element>> elements() {
		return elements.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> {
			Object value = e.getValue();
			return value instanceof Element element ? Reflectable.wrap(element) : (Builder<Element>) value;
		}, (m1, m2) -> {
			throw new IllegalStateException("Merge of duplicate annotation value keys not allowed");
		}, LinkedHashMap::new));
	}

	@Override
	public GenericAnnotationBuilder element(@NotNull String name, @NotNull Element element) {
		elements.put(name, element);
		return this;
	}

	@Override
	public GenericAnnotationBuilder element(@NotNull String name, @NotNull Builder<? extends Element> element) {
		elements.put(name, element);
		return this;
	}

	@Override
	public InstanceType type() {
		return type;
	}

	@Override
	public GenericAnnotationBuilder type(InstanceType type) {
		this.type = type;
		return this;
	}
}
