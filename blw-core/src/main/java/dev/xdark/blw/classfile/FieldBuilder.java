package dev.xdark.blw.classfile;

import dev.xdark.blw.classfile.generic.GenericFieldBuilder;
import dev.xdark.blw.constant.Constant;
import dev.xdark.blw.type.ClassType;
import org.jetbrains.annotations.Nullable;

public interface FieldBuilder<E extends Field, B extends FieldBuilder<E, B>>
		extends MemberBuilder<ClassType, E, B> {

	@Nullable
	Constant defaultValue();

	B defaultValue(@Nullable Constant value);

	static FieldBuilder<?, ?> builder(int accessFlags, String name, ClassType type) {
		return new GenericFieldBuilder(accessFlags, name, type);
	}
}
