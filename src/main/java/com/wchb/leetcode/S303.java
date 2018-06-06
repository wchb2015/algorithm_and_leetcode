package com.wchb.leetcode;

/**
 * @date 6/5/18 5:28 PM
 */
public class S303 {
}

class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {

        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }

            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }

    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }


    private class SegmentTree<E> {

        private E[] tree;

        private E[] data;

        private IMerger<E> merger;

        public SegmentTree(E[] arr, IMerger<E> merger) {
            this.merger = merger;
            data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }

            tree = (E[]) new Object[4 * arr.length];

            buildSegmentTree(0, 0, data.length - 1);
        }

        //在treeIndex的位置创建表示区间[l...r]的线段树
        private void buildSegmentTree(int treeIndex, int l, int r) {
            //递归结束
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }

            int mid = l + (r - l) / 2;//防止数据过大溢出

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        public E get(int index) {
            if (index < 0 || index >= data.length) {
                throw new RuntimeException("Index is illegal!");
            }
            return data[index];
        }

        public int getSize() {
            return data.length;
        }

        //返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引.
        private int leftChild(int index) {
            return 2 * index + 1;
        }

        // 返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子节点的索引
        private int rightChild(int index) {
            return 2 * index + 2;
        }


        // 返回区间[queryL, queryR]的值
        public E query(int queryL, int queryR) {
            if (queryL < 0 || queryL >= data.length ||
                    queryR < 0 || queryR >= data.length || queryL > queryR) {
                throw new IllegalArgumentException("Index is illegal.");
            }
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        // 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {

            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }

            int mid = l + (r - l) / 2;

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, l, mid, queryL, queryR);
            }

            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }

    }

    private interface IMerger<E> {

        E merge(E a, E b);

    }

}
