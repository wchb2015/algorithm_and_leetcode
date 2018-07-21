package com.wchb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 7/18/18 2:10 PM
 */

//Union Find
public class S261 {

    int[] parent;

    public boolean validTree(int n, int[][] edges) {
        init(n);

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return false;
            }
            union(edge[0], edge[1]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(find(i));
        return set.size() == 1;
    }

    private void init(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            //Initially, all slots of parent array are initialized to -1
            // means there is only one item in every subset.
            parent[i] = -1;
        }
    }

    private int find(int v) {
        return parent[v] == -1 ? v : parent[v];
    }

    private void union(int v1, int v2) {

        int pId1 = find(v1);
        int pId2 = find(v2);

        if (pId1 == pId2) {
            return;
        }

        for (int i = 0; i < parent.length; i++) {
            if (find(i) == pId1) {
                parent[i] = pId2;
            }
        }
    }
}
