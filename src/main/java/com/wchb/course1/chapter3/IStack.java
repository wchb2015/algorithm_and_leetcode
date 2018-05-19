package com.wchb.course1.chapter3;

public interface IStack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

}
