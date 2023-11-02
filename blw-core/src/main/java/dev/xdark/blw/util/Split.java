package dev.xdark.blw.util;

import org.jetbrains.annotations.NotNull;

/**
 * Represents a split in the builder pattern, allowing access in builder chains to both the parent builder context,
 * and the newly created child builder for some sub-value being added to the parent.
 *
 * @param <P>
 * 		Parent type.
 * @param <C>
 * 		Child type.
 */
public interface Split<P, C> {
	/**
	 * @return Parent value.
	 */
	@NotNull
	P parent();

	/**
	 * @return Child value.
	 */
	@NotNull
	C child();

	/**
	 * @param parent
	 * 		Parent value.
	 * @param child
	 * 		Child value.
	 * @param <P>
	 * 		Parent type.
	 * @param <C>
	 * 		Child type.
	 *
	 * @return Split of a given parent/child.
	 */
	@NotNull
	static <P, C> Split<P, C> of(P parent, C child) {
		return new SplitImpl<>(parent, child);
	}

	/**
	 * Basic split implementation.
	 *
	 * @param parent
	 * 		Parent value.
	 * @param child
	 * 		Child value.
	 * @param <P>
	 * 		Parent type.
	 * @param <C>
	 * 		Child type.
	 */
	record SplitImpl<P, C>(P parent, C child) implements Split<P, C> {
	}
}
