package com.wchb.course1.chapter11;

/**
 * @date 6/7/18 11:54 AM
 */
//基于size的优化
public class UnionFind3 implements IUF {

    private int[] parent; // parent[i]表示第i个元素所指向的父节点
    private int[] sz;     // sz[i]表示以i为根的集合中元素个数

    //构造函数
    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        //初始化,每一个parent[i] 指向自己,表示每一个元素自己自成一格集合
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        //根据两个元素所在的树的元素的个数不同判断合并的方向
        //将元素个数少的集合合并到元素个数多的集合上

        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {// sz[qRoot] <= sz[pRoot]
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }

    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度,h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
