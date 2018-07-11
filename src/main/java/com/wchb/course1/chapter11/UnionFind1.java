package com.wchb.course1.chapter11;

/**
 * @date 6/6/18 11:18 PM
 */
public class UnionFind1 implements IUF {

    //存每一个id对应的集合的编号
    private int[] id;

    public UnionFind1(int size) {

        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;//每一个元素都属于不同的集合
        }
    }

    // 查找id为p的元素所对应的集合id
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    //合并id为p的元素和id为q元素所属的集合
    public void unionElements(int p, int q) {

        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    @Override
    //查看元素p和元素q是否属于一个集合
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

}
