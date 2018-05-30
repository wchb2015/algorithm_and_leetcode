package com.wchb.course1.chapter7;

public interface ISet<E> {

    //不添加重复元素
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
