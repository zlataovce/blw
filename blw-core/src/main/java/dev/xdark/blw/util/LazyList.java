package dev.xdark.blw.util;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Supplier;

public class LazyList<T> implements List<T> {
	private final Supplier<List<T>> supplier;
	private List<T> delegate;

	public LazyList(@NotNull Supplier<List<T>> supplier) {
		this.supplier = supplier;
	}

	public static <T> LazyList<T> arrayList() {
		return new LazyList<>(ArrayList::new);
	}

	protected List<T> delegate() {
		if (delegate == null)
			delegate =  supplier.get();
		return delegate;
	}

	@Override
	public int size() {
		return delegate().size();
	}

	@Override
	public boolean isEmpty() {
		return delegate().isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return delegate().contains(o);
	}

	@NotNull
	@Override
	public Iterator<T> iterator() {
		return delegate().iterator();
	}

	@NotNull
	@Override
	public Object[] toArray() {
		return delegate().toArray();
	}

	@NotNull
	@Override
	public <T1> T1[] toArray(@NotNull T1[] a) {
		return delegate().toArray(a);
	}

	@Override
	public boolean add(T t) {
		return delegate().add(t);
	}

	@Override
	public boolean remove(Object o) {
		return delegate().remove(o);
	}

	@Override
	public boolean containsAll(@NotNull Collection<?> c) {
		return delegate().containsAll(c);
	}

	@Override
	public boolean addAll(@NotNull Collection<? extends T> c) {
		return delegate().addAll(c);
	}

	@Override
	public boolean addAll(int index, @NotNull Collection<? extends T> c) {
		return delegate().addAll(index, c);
	}

	@Override
	public boolean removeAll(@NotNull Collection<?> c) {
		return delegate().removeAll(c);
	}

	@Override
	public boolean retainAll(@NotNull Collection<?> c) {
		return delegate().retainAll(c);
	}

	@Override
	public void clear() {
		delegate().clear();
	}

	@Override
	public T get(int index) {
		return delegate().get(index);
	}

	@Override
	public T set(int index, T element) {
		return delegate().set(index, element);
	}

	@Override
	public void add(int index, T element) {
		delegate().add(index, element);
	}

	@Override
	public T remove(int index) {
		return delegate().remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return delegate().indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return delegate().lastIndexOf(o);
	}

	@NotNull
	@Override
	public ListIterator<T> listIterator() {
		return delegate().listIterator();
	}

	@NotNull
	@Override
	public ListIterator<T> listIterator(int index) {
		return delegate().listIterator(index);
	}

	@NotNull
	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return delegate().subList(fromIndex, toIndex);
	}
}
