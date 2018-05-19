package com.wchb.course1.chapter3;

public interface IQueue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}

