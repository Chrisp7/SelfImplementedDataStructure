package com.champion;

/**
 * Created by CP on 01/08/2018.
 */
public interface Stack<T> {
    void push(T t);
    T pop();
    T peek();
    int getSize();
    boolean isEmpty();

}
