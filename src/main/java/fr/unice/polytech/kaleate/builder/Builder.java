package fr.unice.polytech.kaleate.builder;

public interface Builder<R> {
    public void reset();

    public R getResult();
}
