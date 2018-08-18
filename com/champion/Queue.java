package com.champion;

/**
 * Created by CP on 03/08/2018.
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
