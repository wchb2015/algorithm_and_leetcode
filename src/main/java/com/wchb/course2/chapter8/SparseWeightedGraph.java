package com.wchb.course2.chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 6/14/18 8:51 AM
 */

// 稀疏图 - 邻接表
public class SparseWeightedGraph<Weight extends Number & Comparable> implements IWeightedGraph {


    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;   // 是否为有向图
    private List<Edge<Weight>>[] g;   // 图的具体数据

    // 构造函数
    public SparseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;    // 初始化没有任何边
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = (List<Edge<Weight>>[]) new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge e) {

        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;

        // 注意,由于在邻接表的情况,查找是否有重边需要遍历整个链表
        // 我们的程序允许重边的出现

        g[e.v()].add(new Edge(e));
        if (e.v() != e.w() && !directed) {
            g[e.w()].add(new Edge(e.w(), e.v(), e.weight()));
        }

        m++;
    }

    // 验证图中是否有从v到w的边
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i).other(v) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("list " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                Edge e = g[i].get(j);
                System.out.print("( to:" + e.other(i) + ",wt:" + e.weight() + ")\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> iterable(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
