package com.wchb.course2.chapter8;

/**
 * @date 6/14/18 8:46 AM
 */
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge> {

    private int a, b;    // 边的两个端点
    private Weight weight;  // 边的权值

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge(Edge<Weight> e) {
        this.a = e.a;
        this.b = e.b;
        this.weight = e.weight;
    }

    // 返回第一个顶点
    public int v() {
        return a;
    }

    // 返回第二个顶点
    public int w() {
        return b;
    }

    // 返回权值
    public Weight weight() {
        return weight;
    }

    // 给定一个顶点, 返回另一个顶点
    public int other(int x) {
        assert x == a || x == b;
        return x == a ? b : a;
    }

    @Override
    public String toString() {
        return "" + a + "-" + b + ": " + weight;
    }

    @Override
    public int compareTo(Edge that) {
        if (weight.compareTo(that.weight()) < 0) {
            return -1;
        } else if (weight.compareTo(that.weight()) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
