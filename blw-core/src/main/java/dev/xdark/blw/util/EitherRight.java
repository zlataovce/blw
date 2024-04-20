package dev.xdark.blw.util;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

record EitherRight<L, R>(R right) implements Either<L, R> {

    @Override
    public L left() {
        throw new NoSuchElementException("left");
    }


    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public boolean isRight() {
        return true;
    }

    @Override
    public Either<L, R> ifLeft(Consumer<? super L> consumer) {
        return this;
    }

    @Override
    public Either<L, R> ifRight(Consumer<? super R> consumer) {
        consumer.accept(right);
        return this;
    }

    @Override
    public Either<L, R> accept(Consumer<? super L> left, Consumer<? super R> right) {
        right.accept(this.right);
        return this;
    }

    @Override
    public Either<R, L> swap() {
        return new EitherLeft<>(right);
    }
}
