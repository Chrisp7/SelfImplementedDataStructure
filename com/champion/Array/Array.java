package com.champion.Array;

/**
 * Created by CP on 31/07/2018.
 */
// the E is randomly picked
public class Array<T> {
    private T[] data;
    private int size;

    // if the capacity has been specified
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // if the capacity hasn't been specified
    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, T e) {
        //don't forget to check the index
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The index is illegal");
        } else if (size == data.length) {
            resize(data.length * 2);
        } else {
            for (int i = size - 1; index <= i; i--) {
                data[i + 1] = data[i];
            }
            data[index] = e;
            size++;
        }
    }

    public void addLast(T e) {
        add(size, e);
        // after you define add, you can just use add to defind this function, just write add(size,e);
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal Argument");
        } else {
            return data[index];
        }
    }

    public T getLast() {
        return get(size - 1);
        // don't use return data[size], cause the size may be negative, and you have to check for it.
        // the function get has already help us implement it.
    }

    public T getFirst() {
        return data[0];
    }

    public void delete(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal Argument");
        } else {
            for (int i = index; i < size; i++) {
                data[i] = data[i + 1];
            }
            size--;
            if (size <= data.length / 2) {
                resize(data.length / 2);
            }
        }
    }

    public T removeLast() {
        T res = data[size];
        size--;
        if (size <= data.length / 2) {
            resize(data.length / 2);
        }
        return res;

    }

    public void deleteElement(T e) {
        int index = find(e);
        if (index != -1) {
            delete(index);
        }
    }

    public boolean contains(T e) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    public int find(T e) {
        int pos = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                pos = i;
            } else {
                pos = -1;
            }
        }
        return pos;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Array: size=%d, capacity=%d\n", size, data.length));
        str.append("[");
        for (int i = 0; i < size; i++) {
            str.append(data[i]);
            if (i != size - 1) {
                str.append(",");
            }
        }
        str.append("]");
        return str.toString();
    }

    public void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
