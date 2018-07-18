package com.wchb.course1.chapter12;

import com.wchb.course1.chapter7.ISet;

/**
 * @date 7/17/18 8:31 AM
 */
public class AVLSet<E extends Comparable<E>> implements ISet<E> {

    private AVLTree<E, Object> avl;

    public AVLSet() {
        avl = new AVLTree<>();
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public void add(E e) {
        avl.add(e, null);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }
}