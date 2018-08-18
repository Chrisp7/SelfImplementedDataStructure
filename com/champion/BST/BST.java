package com.champion.BST;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

/**
 * Created by CP on 10/08/2018.
 */
public class BST<E extends Comparable<E>> {
    private Stack<Node> stack;
    private Queue<Node> queue;

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private int size;
    private Node root;

    public BST() {
        size = 0;
        root = null;
        stack = new Stack<>();
        queue = new LinkedList<>();

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add2(root, e);
    }

    private void add1(Node node, E e) {
        if (e.equals(e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        } else {
            if (e.compareTo(node.e) < 0)
                add1(node.left, e);
            else
                add1(node.right, e);
        }

    }

    private Node add2(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        } else {
            if (e.compareTo(node.e) < 0)
                node.left = add2(node.left, e);
            else if (e.compareTo(node.e) > 0)
                node.right = add2(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        else if (e.equals(node.e))
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR() {
        preOrderNR(root);
    }

    private void preOrderNR(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("can not traverse empty tree");
        }

        stack.push(node);
        while (!stack.empty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);

        }
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node node) {
        if (node == null)
            return;
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    public E getMin() {
        if (size == 0)
            throw new IllegalArgumentException("error, the tree is empty");

        return getMin(root);
    }

    private E getMin(Node node) {
        if (node.left == null)
            return node.e;

        return getMin(node.left);
    }


    public E removeMin() {
        E ret = getMin();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightChild = node.right;
            node.right = null;
            node = null;
            size--;
            return rightChild;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E getMax() {
        if (size == 0)
            throw new IllegalArgumentException("error, the tree is empty");

        return getMax(root);
    }

    private E getMax(Node node) {
        if (node.right == null)
            return node.e;

        return getMin(node.right);
    }


    public E removeMax() {
        E ret= getMax();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftChild = node.left;
            node.left = null;
            node = null;
            size--;
            return leftChild;
        }
        node.right = removeMin(node.right);
        return node;
    }

    public void remove(E e){
        remove(root,e);
    }

    private Node remove(Node node,E e){
        if (node==null)
            return null;
        else if (e.compareTo(node.e)<0) {
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e)>0) {
            node.right = remove(node.right, e);
            return node;
        }
        else{
            if (node.left==null){
                Node rightNode=node.right;
                size--;
                node.right=null;
                return rightNode;
            }
            else if (node.right==null){
                Node leftNode= node.left;
                size--;
                node.left=null;
                return leftNode;
            }
            else {
                // get the minimum node from right child of the node
                Node successor = new Node(getMin(node.right));
                successor.left = node.left;
                successor.right = removeMin(node.right);

                node.left = node.right = null;
                return successor;
            }
        }

    }
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTPreOrder(root, 0, res);
        return res.toString();
    }

    private void generateBSTPreOrder(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepth(depth) + "null\n");
            return;
        }
        res.append(generateDepth(depth) + node.e + "\n");
        generateBSTPreOrder(node.left, depth + 1, res);
        generateBSTPreOrder(node.right, depth + 1, res);

    }

    private String generateDepth(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


}
