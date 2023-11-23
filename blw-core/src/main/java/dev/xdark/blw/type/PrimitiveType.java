package dev.xdark.blw.type;

import org.jetbrains.annotations.NotNull;

public final class PrimitiveType implements ClassType {
	private final String descriptor;
	private final int kind;
	private final String name;

	PrimitiveType(String descriptor, int kind, String name) {
		this.descriptor = descriptor;
		this.kind = kind;
		this.name = name;
	}

	@NotNull
	public InstanceType box() {
		return switch (kind) {
			case PrimitiveKind.T_BOOLEAN -> Types.BOX_BOOLEAN;
			case PrimitiveKind.T_BYTE -> Types.BOX_BYTE;
			case PrimitiveKind.T_CHAR -> Types.BOX_CHAR;
			case PrimitiveKind.T_SHORT -> Types.BOX_SHORT;
			case PrimitiveKind.T_INT -> Types.BOX_INT;
			case PrimitiveKind.T_FLOAT -> Types.BOX_FLOAT;
			case PrimitiveKind.T_LONG -> Types.BOX_LONG;
			case PrimitiveKind.T_DOUBLE -> Types.BOX_DOUBLE;
			case PrimitiveKind.T_VOID -> throw new IllegalStateException("Cannot box void");
			default -> throw new IllegalStateException("Unknown primitive type: " + descriptor);
		};
	}

	@NotNull
	public PrimitiveType widen(@NotNull PrimitiveType other) {
		int kind = this.kind;
		int otherKind = other.kind;
		if (kind == otherKind) return this;
		return switch (kind) {
			case PrimitiveKind.T_BOOLEAN -> widenBooleanTo(otherKind);
			case PrimitiveKind.T_BYTE -> widenByteTo(otherKind);
			case PrimitiveKind.T_CHAR -> widenCharTo(otherKind);
			case PrimitiveKind.T_SHORT -> widenShortTo(otherKind);
			case PrimitiveKind.T_INT -> widenIntTo(otherKind);
			case PrimitiveKind.T_FLOAT -> widenFloatTo(otherKind);
			case PrimitiveKind.T_LONG -> Types.LONG;
			case PrimitiveKind.T_DOUBLE -> Types.DOUBLE;
			case PrimitiveKind.T_VOID -> throw new IllegalStateException("Cannot widen void");
			default -> throw new IllegalStateException("Unknown primitive type: " + descriptor);
		};
	}

	private @NotNull PrimitiveType widenBooleanTo(int otherKind) {
		return switch (otherKind) {
			case PrimitiveKind.T_BYTE -> Types.BYTE;
			case PrimitiveKind.T_SHORT -> Types.SHORT;
			case PrimitiveKind.T_CHAR -> Types.CHAR;
			case PrimitiveKind.T_INT -> Types.INT;
			case PrimitiveKind.T_LONG -> Types.LONG;
			case PrimitiveKind.T_DOUBLE -> Types.DOUBLE;
			case PrimitiveKind.T_FLOAT -> Types.FLOAT;
			default -> this;
		};
	}

	private @NotNull PrimitiveType widenByteTo(int otherKind) {
		return switch (otherKind) {
			case PrimitiveKind.T_SHORT -> Types.SHORT;
			case PrimitiveKind.T_CHAR -> Types.CHAR;
			case PrimitiveKind.T_INT -> Types.INT;
			case PrimitiveKind.T_LONG -> Types.LONG;
			case PrimitiveKind.T_DOUBLE -> Types.DOUBLE;
			case PrimitiveKind.T_FLOAT -> Types.FLOAT;
			default -> this;
		};
	}

	private @NotNull PrimitiveType widenCharTo(int otherKind) {
		return switch (otherKind) {
			case PrimitiveKind.T_INT -> Types.INT;
			case PrimitiveKind.T_LONG -> Types.LONG;
			case PrimitiveKind.T_DOUBLE -> Types.DOUBLE;
			case PrimitiveKind.T_FLOAT -> Types.FLOAT;
			default -> this;
		};
	}

	private @NotNull PrimitiveType widenShortTo(int otherKind) {
		return switch (otherKind) {
			case PrimitiveKind.T_INT -> Types.INT;
			case PrimitiveKind.T_LONG -> Types.LONG;
			case PrimitiveKind.T_DOUBLE -> Types.DOUBLE;
			case PrimitiveKind.T_FLOAT -> Types.FLOAT;
			default -> this;
		};
	}

	private @NotNull PrimitiveType widenIntTo(int otherKind) {
		return switch (otherKind) {
			case PrimitiveKind.T_LONG -> Types.LONG;
			case PrimitiveKind.T_DOUBLE -> Types.DOUBLE;
			case PrimitiveKind.T_FLOAT -> Types.FLOAT;
			default -> this;
		};
	}

	private @NotNull PrimitiveType widenFloatTo(int otherKind) {
		if (otherKind == PrimitiveKind.T_DOUBLE) return Types.DOUBLE;
		return this;
	}

	public int kind() {
		return kind;
	}

	public String name() {
		return name;
	}

	@Override
	public String descriptor() {
		return descriptor;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof PrimitiveType that)) return false;
		return kind == that.kind;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(kind);
	}

	@Override
	public String toString() {
		return descriptor;
	}
}
