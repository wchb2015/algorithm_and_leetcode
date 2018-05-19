package com.wchb.course1.chapter7;

public interface ISet<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
