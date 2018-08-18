package com.champion.LinkedList;

import com.champion.Queue;

/**
 * Created by CP on 08/08/2018.
 */
public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        public String toString() {
            return e.toString();
        }
    }
    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getSize()==0;
    }

    @Override
    public void enqueue(E e) {
        if (head==null){
            head=new Node(e);
            tail=head;
        }else{
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (size==0){
            throw new IllegalArgumentException("cannot dequeue from empty queue");
        }
        if (head==tail) {
            Node ret = head;
            head = tail = null;
            size = 0;
            return ret.e;
        }else{
            Node ret=head;
            head=head.next;
            size--;
            return ret.e;
        }
    }

    @Override
    public E getFront() {
        if (size==0){
            throw new IllegalArgumentException("cannot dequeue from empty queue");
        }
        return head.e;
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("LinkedListQueue top: "));
        Node cur=head;
        while (cur.next!=null){
            res.append(cur.e+"->");
            cur=cur.next;
        }
        res.append(cur.e+"->null");

        return res.toString();
    }

    public static void main(String args[]){
        LinkedListQueue<Integer> lq=new LinkedListQueue<>();
        for (int i = 0;i<10;i++){
            lq.enqueue(i);
            System.out.println(lq);
            if (i%3==2){
                lq.dequeue();
                System.out.println(lq);
            }
        }
    }

}
