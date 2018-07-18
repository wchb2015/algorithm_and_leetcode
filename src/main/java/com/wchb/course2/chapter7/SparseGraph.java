package com.wchb.course2.chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 6/13/18 2:06 PM
 */

// 稀疏图 - 邻接表
public class SparseGraph implements IGraph {
    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;    // 是否为有向图
    private List<Integer>[] g; // 图的具体数据

    // 构造函数
    public SparseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;    // 初始化没有任何边
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = (List<Integer>[]) new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    // 返回节点个数
    @Override
    public int V() {
        return n;
    }

    // 返回边的个数
    @Override
    public int E() {
        return m;
    }

    // 向图中添加一个边
    @Override
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
        }

        m++;
    }

    // 验证图中是否有从v到w的边
    @Override
    public boolean hasEdge(int v, int w) {

        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i) == w) {
                return true;
            }
        }

        return false;
    }

    /*  list 0:	1	2	5
        list 1:	0	2	3	4
        list 2:	0	1
        list 3:	1	4	5
        list 4:	1	3
        list 5:	0	3*/
    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("list " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                System.out.print(g[i].get(j) + "\t");
            }
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    // 临边迭代器
    @Override
    public Iterable<Integer> iterable(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

}
