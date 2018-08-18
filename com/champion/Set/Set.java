package com.champion.Set;

/**
 * Created by CP on 17/08/2018.
 */
public interface Set<E> {
    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();
}
