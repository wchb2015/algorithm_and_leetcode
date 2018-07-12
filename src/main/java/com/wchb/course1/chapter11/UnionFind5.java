package com.wchb.course1.chapter11;

/**
 * @date 6/7/18 1:13 PM
 */

//路径压缩
//深度低的树向深度高的树合并
//基于rank的优化,rank[i]表示根节点为i的树的高度
public class UnionFind5 implements IUF {

    // rank[i]表示以i为根的集合所表示的树的层数
    private int[] rank;

    //parent[i]表示第i个元素所指向的父节点
    private int[] parent;

    public UnionFind5(int size) {

        rank = new int[size];
        parent = new int[size];

        //初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查找过程, 查找元素p所对应的集合的编号
    // O(h)复杂度, h为树的高度
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    //合并元素P和元素q所属的结合
    //o(h)复杂度, h为树的高度
    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在树的rank不同判断合并方向
        // 讲rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else if (rank[pRoot] == rank[qRoot]) {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }

    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
