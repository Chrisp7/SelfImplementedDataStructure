package com.champion.Map;

import com.champion.FileOperator;

import java.util.ArrayList;

/**
 * Created by CP on 21/08/2018.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;

        }

        public Node() {
            key = null;
            value = null;
            left = null;
            right = null;
        }
    }

    public Node root;
    public int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(Node node, K key) {
        if (node == null)
            return null;

        if (node.key.compareTo(key) < 0)
            return getNode(node.right, key);
        else if (node.key.compareTo(key) > 0)
            return getNode(node.left, key);
        else
            return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node cur = getNode(root, key);
        if (cur == null) {
            throw new IllegalArgumentException("there is no such key in this map");
        } else
            cur.value = newValue;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);

    }

    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        } else {
            if (key.compareTo(node.key) < 0)
                node.left = add(node.left, key, value); //it's not return node.left=add(node.left, key, value);
            else if (key.compareTo(node.key) > 0)
                node.right = add(node.right, key, value);
            else
                node.value = value;
            return node;
        }
    }

    @Override
    public V remove(K key) {
        Node cur = getNode(root, key);
        if (cur == null) {
            throw new IllegalArgumentException("there is no such key in this map");
        }
        return remove(root, key).value;
    }

    private Node getMin(Node node) {
        if (node.left == null)
            return node;
        return getMin(node.left);

    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;

    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        else if (key.compareTo(node.key) < 0)
            return node.left = remove(node.left, key);
        else if (key.compareTo(node.key) > 0)
            return node.right = remove(node.right, key);
        else {
            if (node.left == null) {
                Node temp = node.right;
                node.right = null;
                size--;
                return temp;

            } else if (node.right == null) {
                Node temp = node.left;
                node.left = null;
                size--;
                return temp;
            } else {
                Node minNode = getMin(node.right);
                minNode.right = removeMin(node.right);
                minNode.left = node.left;

                node.left = node.right = null;
                return minNode;
            }

        }
    }


    public static void main(String[] args) {
        FileOperator fo = new FileOperator();
        ArrayList<String> words = new ArrayList<>();
        if (fo.readFile("/Users/CP/Documents/Study/code/intellij/imoocDataStructure/src/com/champion/pride-and-prejudice.txt", words)) {
            System.out.println("pride-and-prejudice");
            BSTMap<String, Integer> map = new BSTMap<>();
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
