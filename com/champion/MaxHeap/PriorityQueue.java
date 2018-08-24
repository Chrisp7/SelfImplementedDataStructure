package com.champion.MaxHeap;

import com.champion.Queue;

/**
 * Created by CP on 24/08/2018.
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxheap;

    public PriorityQueue() {
        maxheap = new MaxHeap<E>();
    }

    @Override
    public int getSize() {
        return maxheap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxheap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxheap.add(e);
    }

    @Override
    public E dequeue() {
        return maxheap.extractMax();
    }

    @Override
    public E getFront() {
        return maxheap.findMax();
    }
}
