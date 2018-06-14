package com.wchb.course2.chapter7;

/**
 * @date 6/13/18 2:48 PM
 */
public interface IGraph {

    int V();

    int E();

    void addEdge(int v, int w);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Integer> iterable(int v);
}
