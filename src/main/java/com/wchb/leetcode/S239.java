package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @date 11/4/18 2:50 PM
 */
public class S239 {


    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) return nums;
        SegmentTree st = new SegmentTree(nums);
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i + k <= nums.length; i++) {
            arrayList.add(st.query(i, i + k - 1));
        }

        int[] ans = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ans[i] = arrayList.get(i);
        }

        Collections.sort(arrayList);

        return ans;
    }


    private static class SegmentTree {
        private int[] tree;
        private int[] data;

        SegmentTree(int[] data) {
            this.data = data;
            tree = new int[4 * data.length];
            buildSegmentTree(0, 0, data.length - 1);
        }


        private void buildSegmentTree(int treeIndex, int l, int r) {

            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }

            int mid = l + (r - l) / 2;

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);

            tree[treeIndex] = Math.max(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        public int query(int queryL, int queryR) {
            if (queryL < 0 || queryL >= data.length ||
                    queryR < 0 || queryR >= data.length || queryL > queryR) {
                throw new IllegalArgumentException("Index is illegal.");
            }
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        private int query(int treeIndex, int l, int r, int queryL, int queryR) {

            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }

            int mid = l + (r - l) / 2;
            // treeIndex的节点分为[l...mid]和[mid+1...r]两部分

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, l, mid, queryL, queryR);
            }

            int leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            int rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return Math.max(leftResult, rightResult);
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }
    }

}
