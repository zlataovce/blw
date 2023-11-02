package dev.xdark.blw.classfile;

import dev.xdark.blw.annotation.Element;
import dev.xdark.blw.classfile.attribute.Parameter;
import dev.xdark.blw.code.Code;
import dev.xdark.blw.code.CodeBuilder;
import dev.xdark.blw.type.InstanceType;
import dev.xdark.blw.type.MethodType;
import dev.xdark.blw.util.Reflectable;
import dev.xdark.blw.util.Split;

import java.util.List;

public interface MethodBuilder<E extends Method, B extends MethodBuilder<E, B>>
		extends MemberBuilder<MethodType, E, B> {

	List<InstanceType> exceptionTypes();

	B exceptionTypes(List<InstanceType> exceptionTypes);

	List<Parameter> parameters();

	B parameters(List<Parameter> parameters);

	B parameter(Parameter parameter);

	Reflectable<Code> getCode();

	B code(Code code);

	Split<B, CodeBuilder<?>> code();

	Reflectable<? extends Element> annotationDefault();

	B annotationDefault(Element annotationDefault);

	B annotationDefault(Reflectable<? extends Element> annotationDefault);
}
