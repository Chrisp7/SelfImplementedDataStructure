package com.champion.Map;

import com.champion.FileOperator;

import java.util.ArrayList;

/**
 * Created by CP on 20/08/2018.
 */
public class LinkedlistMap<K, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
            key = null;
            value = null;
            next = null;
        }
    }

    private Node DummyHead;
    private int size;

    public LinkedlistMap() {
        DummyHead = new Node();
        size = 0;
    }

    public Node getNode(K k) {
        Node cur = DummyHead.next;
        while (cur != null) {
            if (cur.key.equals(k))
                return cur;

            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }


    @Override
    public boolean contains(K key) {
        Node cur = getNode(key);
        if (cur == null)
            return false;
        else
            return true;
    }

    @Override
    public V get(K key) {
        Node cur = getNode(key);
        return cur == null ? null : cur.value;
    }


    @Override
    public void add(K key, V value) {
        Node cur = getNode(key);
        if (cur == null) {
            DummyHead.next = new Node(key, value, DummyHead.next);

            size++;
        } else
            cur.value = value;
    }


    @Override
    public void set(K key, V newValue) {
        Node cur = getNode(key);
        if (cur == null)
            throw new IllegalArgumentException("do not have this key in the map");
        else
            cur.value = newValue;
    }


    @Override
    public V remove(K key) {
        /*
        Node delNode = getNode(key);
        if (delNode == null)
            throw new IllegalArgumentException("do not have this key in the map");
        else {
            Node cur = DummyHead.next;
            while (cur.next != delNode) {
                cur = cur.next;
            }
            cur.next = delNode.next;
            delNode.next = null;
            size--;
        }
        return delNode.value;
        */
        Node pre = DummyHead;
        while (pre.next != null) {
            if (pre.next.key.equals(key))
                break;
            pre = pre.next;
        }
        if (pre.next != null) {
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        } else {
            return null;
        }

    }


    public static void main(String[] args) {
        FileOperator fo = new FileOperator();
        ArrayList<String> words = new ArrayList<>();
        if (fo.readFile("/Users/CP/Documents/Study/code/intellij/imoocDataStructure/src/com/champion/pride-and-prejudice.txt", words)) {
            System.out.println("pride-and-prejudice");
            LinkedlistMap<String, Integer> map = new LinkedlistMap<>();
            long startTime = System.nanoTime();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            long endTime = System.nanoTime();
            System.out.println("The building of map takes: " + (endTime - startTime) / 1000000000.0 + "s");
            System.out.println("There are total " + map.getSize() + " words");
            System.out.println("The frequency of pride is: " + map.get("pride"));
            System.out.println("The frequency of prejudice is: " + map.get("prejudice"));
        }

    }

}
