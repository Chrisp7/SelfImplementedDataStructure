package com.champion.Array;

import com.champion.Stack;

/**
 * Created by CP on 01/08/2018.
 */
public class ArrayStack<T> implements Stack<T> {
    Array<T> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<T>();
    }

    @Override
    public void push(T t) {
        array.addLast(t);
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Stack: [");
        for (int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if (i!=array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
