package com.wchb.course1.chapter11;

/**
 * @date 6/7/18 10:57 AM
 */

//Quick Union
public class UnionFind2 implements IUF {

    // Union-Find,使用一个数组构建一棵指向父节点的树
    // parent[i] 表示id为i的元素所指向的父节点的ID.
    private int[] parent;

    //构造函数
    public UnionFind2(int size) {
        parent = new int[size];
        //初始化,每一个parent[i]指向自己,表示每一个元素自己自成一个集合
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    //查找过程,查找元素P所对应的集合的编号
    //o(h)复杂度,h为树的高度.
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        // 不断去查询自己的父亲节点,知道到达根节点
        // 根节点的特点: parent[p] == p
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        parent[pRoot] = qRoot;
    }

    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度, h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

}
