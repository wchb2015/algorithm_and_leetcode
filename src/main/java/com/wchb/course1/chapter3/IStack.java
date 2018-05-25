package com.wchb.course1.chapter3;

public interface IStack<E> {

    int getSize();

    boolean isEmpty();

    //入栈
    void push(E e);

    //出栈
    E pop();

    //查看栈顶元素
    E peek();

}
