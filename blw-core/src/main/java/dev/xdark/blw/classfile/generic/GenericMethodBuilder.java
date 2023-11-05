package dev.xdark.blw.classfile.generic;

import dev.xdark.blw.annotation.Element;
import dev.xdark.blw.classfile.MethodBuilder;
import dev.xdark.blw.classfile.attribute.Parameter;
import dev.xdark.blw.code.Code;
import dev.xdark.blw.code.CodeBuilder;
import dev.xdark.blw.code.generic.GenericCodeBuilder;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.type.MethodType;
import dev.xdark.blw.util.Reflectable;
import dev.xdark.blw.util.Split;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodBuilder extends GenericMemberBuilder<MethodType, GenericMethod, GenericMethodBuilder>
		implements MethodBuilder<GenericMethod, GenericMethodBuilder> {
	protected List<InstanceType> exceptionTypes = List.of();
	protected List<Parameter> parameters = List.of();
	protected Reflectable<Code> code;
	protected Reflectable<? extends Element> annotationDefault;

	public GenericMethodBuilder(int accessFlags, String name, MethodType type) {
		this.accessFlags = accessFlags;
		this.name = name;
		this.type = type;
	}

	@Override
	public List<InstanceType> exceptionTypes() {
		return exceptionTypes;
	}

	@Override
	public GenericMethodBuilder exceptionTypes(List<InstanceType> exceptionTypes) {
		this.exceptionTypes = exceptionTypes;
		return this;
	}

	@Override
	public List<Parameter> parameters() {
		return parameters;
	}

	@Override
	public GenericMethodBuilder parameters(List<Parameter> parameters) {
		this.parameters = parameters;
		return this;
	}

	@Override
	public Reflectable<Code> getCode() {
		return code;
	}

	@Override
	public GenericMethodBuilder parameter(Parameter parameter) {
		List<Parameter> parameters = this.parameters;
		if (parameters.isEmpty()) {
			parameters = new ArrayList<>();
			this.parameters = parameters;
		}
		parameters.add(parameter);
		return this;
	}

	@Override
	public GenericMethodBuilder code(Code code) {
		this.code = code;
		return this;
	}

	@Override
	public Split<GenericMethodBuilder, CodeBuilder<?>> code() {
		CodeBuilder<?> builder;
		Reflectable<Code> current = this.code;
		if (current instanceof CodeBuilder<?> currentBuilder) {
			builder = currentBuilder;
		} else {
			builder = new GenericCodeBuilder();
			this.code = builder;
		}
		return Split.of(this, builder);
	}

	@Override
	public Reflectable<? extends Element> annotationDefault() {
		return annotationDefault;
	}

	@Override
	public GenericMethodBuilder annotationDefault(Element annotationDefault) {
		this.annotationDefault = Reflectable.wrap(annotationDefault);
		return this;
	}

	@Override
	public GenericMethodBuilder annotationDefault(Reflectable<? extends Element> annotationDefault) {
		this.annotationDefault = annotationDefault;
		return this;
	}

	@Override
	public GenericMethod build() {
		Reflectable<? extends Element> annotationDefault;
		return new GenericMethod(
				accessFlags,
				name,
				signature,
				visibleRuntimeAnnotations(),
				invisibleRuntimeAnnotation(),
				type,
				code == null ? null : code.reflectAs(),
				exceptionTypes,
				parameters,
				(annotationDefault = this.annotationDefault) == null ? null : annotationDefault.reflectAs()
		);
	}
}
