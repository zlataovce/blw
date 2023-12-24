package dev.xdark.blw.util;

public class SneakyCast {
	@SuppressWarnings("unchecked")
	public static <T, X> T cast(X x) {
		return (T) x;
	}
}
