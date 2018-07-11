package com.wchb.course1.chapter11;

/**
 * @date 6/6/18 11:06 PM
 */
public interface IUF {

    int getSize();

    //id=p,id=q
    void unionElements(int p, int q);

    //只关心id=p,id=q的元素
    boolean isConnected(int p, int q);
}
