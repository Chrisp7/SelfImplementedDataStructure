package com.champion.LinkedList;

/**
 * Created by CP on 07/08/2018.
 */
public class Main {
    public static void main(String args[]) {
        LinkedList<Integer> linkedlist = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedlist.addFirst(i);
            System.out.println(linkedlist);
        }
        linkedlist.add(2, 7);
        System.out.println(linkedlist);

        linkedlist.remove(2);
        System.out.println(linkedlist);

        linkedlist.removeFirst();
        System.out.println(linkedlist);

        linkedlist.removeLast();
        System.out.println(linkedlist);
    }
}
