package dev.xdark.blw.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Supplier;

public class LazyMap<K, V> implements Map<K, V> {
	private final Supplier<Map<K, V>> supplier;
	private Map<K, V> delegate;

	public LazyMap(Supplier<Map<K, V>> supplier) {
		this.supplier = supplier;
	}

	public static <K, V> LazyMap<K, V> linked() {
		return new LazyMap<>(LinkedHashMap::new);
	}

	public static <K, V> LazyMap<K, V> hash() {
		return new LazyMap<>(HashMap::new);
	}

	public static <K, V> LazyMap<K, V> tree() {
		return new LazyMap<>(TreeMap::new);
	}

	protected Map<K, V> delegate() {
		if (delegate == null)
			delegate = supplier.get();
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
	public boolean containsKey(Object key) {
		return delegate().containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return delegate().containsValue(value);
	}

	@Override
	public V get(Object key) {
		return delegate().get(key);
	}

	@Nullable
	@Override
	public V put(K key, V value) {
		return delegate().put(key, value);
	}

	@Override
	public V remove(Object key) {
		return delegate().remove(key);
	}

	@Override
	public void putAll(@NotNull Map<? extends K, ? extends V> m) {
		delegate().putAll(m);
	}

	@Override
	public void clear() {
		delegate().clear();
	}

	@NotNull
	@Override
	public Set<K> keySet() {
		return delegate().keySet();
	}

	@NotNull
	@Override
	public Collection<V> values() {
		return delegate().values();
	}

	@NotNull
	@Override
	public Set<Entry<K, V>> entrySet() {
		return delegate().entrySet();
	}
}
