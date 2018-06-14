package com.wchb.course2.chapter8;

/**
 * @date 6/14/18 8:52 AM
 */
public interface IWeightedGraph<Weight extends Number & Comparable> {

    int V();

    int E();

    void addEdge(Edge<Weight> e);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Edge<Weight>> iterable(int v);

}
