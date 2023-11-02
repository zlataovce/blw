package dev.xdark.blw.classfile;

/**
 * Represents the base of any builder. The recursive generic type can be used as
 * a return type in multiple inheritors so that chained calls to methods belonging to different
 * builders does not lock the return type to the last called method's declaring type.
 * <p/>
 * An example to consider. A {@link Field} is {@link Typed} and {@link Named}.
 * If you have a {@link FieldBuilder} which is also {@link TypedBuilder} and {@link NamedBuilder}
 * calling {@link NamedBuilder#name(String)} and having your builder chain limited to calling just {@link NamedBuilder}
 * would make for a very poor builder. By making all return types {@code B} the {@link FieldBuilder} inherits the
 * {@link NamedBuilder#name(String)} method and infers the return type of {@link FieldBuilder}.
 *
 * @param <B>
 * 		Self builder type.
 */
public interface Self<B extends Self<B>> {
}
