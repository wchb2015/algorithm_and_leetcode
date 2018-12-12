package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 7/20/18 12:05 PM
 */
public class S684UnionFind {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {

        parent = new int[edges.length + 1];

        // Initially, all slots of parent array are initialized to -1
        // means there is only one item in every subset.
        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }
            union(edge[0], edge[1]);
        }

        return null;
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
