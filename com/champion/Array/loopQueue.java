package com.champion.Array;

import com.champion.Queue;

/**
 * Created by CP on 03/08/2018.
 */
public class loopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public loopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public loopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front=0;
        tail=size;
        newData = null;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        // always check the situation of empty
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from empty queue");
        }
        E res = data[front];
        front = (front + 1) % data.length;
        size--;
        if (size <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from empty queue");
        }
        return data[front];
    }

    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("loopQueue: size = %d, capacity = %d\n",size,getCapacity()));
        res.append("loopQueue: f [");
        for (int i=front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if ((i+1)%data.length!=tail){
                res.append(",");
            }
        }
        res.append("] t");
        return res.toString();
    }

    public static void main(String args[]){
        loopQueue<Integer> lq=new loopQueue<>();
        for (int i = 0;i<lq.getCapacity();i++){
            lq.enqueue(i);
            System.out.println(lq);
            if (i%3==2){
                lq.dequeue();
                System.out.println(lq);
            }
        }
    }
}
