package dev.xdark.blw.resolution;

import dev.xdark.blw.classfile.Accessible;

public record ResolutionSuccess<M extends Accessible>(ClassInfo<?, ?> owner, M member,
                                                      boolean isForced) implements ResolutionResult<M> {


}
