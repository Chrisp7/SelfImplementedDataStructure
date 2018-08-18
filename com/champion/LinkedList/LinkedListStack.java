package com.champion.LinkedList;

import com.champion.Stack;

/**
 * Created by CP on 08/08/2018.
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }


    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.getSize()==0;
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
    public static void main(String args[]){
        Stack<Integer> s=new LinkedListStack<>();
        for (int i=0;i<5;i++){
            s.push(i);
            System.out.println(s);
        }
        s.pop();
        System.out.println(s);
        System.out.println(s.peek());

    }
}
