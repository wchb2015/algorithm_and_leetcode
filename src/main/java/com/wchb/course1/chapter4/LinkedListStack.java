package com.wchb.course1.chapter4;

import com.wchb.course1.chapter3.IStack;
import com.wchb.course1.chapter4.LinkedList;

public class LinkedListStack<E> implements IStack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Stack: top ");
        sb.append(linkedList);
        return sb.toString();
    }
}