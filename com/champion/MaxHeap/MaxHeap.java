package com.champion.MaxHeap;

import com.champion.Array.Array;

/**
 * Created by CP on 22/08/2018.
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<E>(capacity);
    }

    public MaxHeap() {
        data = null;
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }

    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

     private int parent(int index) {
        //remember to judge if it is parent node
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

     public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        if (index < 0 || index > data.getSize())
            throw new IllegalArgumentException("Illegal index");
        else {
            while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
                data.swap(index, parent(index));
                index = parent(index);
            }
        }
    }

    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("the heap is empty");
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);

        return ret;
    }

    private void siftDown(int index) {
        if (index < 0 || index > data.getSize())
            throw new IllegalArgumentException("Illegal index");

        while (leftChild(index) < data.getSize()) {
            int j = leftChild(index);
            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) < 0)
                j = rightChild(index);

            // right here the j store the index of greater item between leftchild and rightchild
            if (data.get(j).compareTo(data.get(index)) <= 0)
                break;
            else {
                data.swap(j, index);
                index = j;
            }

        }
    }

    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
