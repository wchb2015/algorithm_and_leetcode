package com.wchb.course1.chapter7;

import com.wchb.course1.chapter4.LinkedList;
import com.wchb.course1.chapter7.ISet;

public class LinkedListSet<E> implements ISet<E> {

    LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (contains(e)) {
            return;
        }
        linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
