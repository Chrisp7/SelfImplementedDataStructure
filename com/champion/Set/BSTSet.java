package com.champion.Set;

import com.champion.BST.BST;

/**
 * Created by CP on 17/08/2018.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    BST<E> bst;

    public BSTSet()

    {
        bst = new BST<E>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
