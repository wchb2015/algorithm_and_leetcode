package com.wchb.leetcode;

/**
 * @date 7/20/18 12:31 PM
 */
public class S685 {
    int[] parent;
    int[] roots;


    public int[] findRedundantDirectedConnection(int[][] edges) {

        parent = new int[edges.length + 1];

        for (int i = 0; i < parent.length; i++) {
            //Initially, all slots of parent array are initialized to -1
            // means there is only one item in every subset.
            parent[i] = -1;
        }

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }
            union(edge[0], edge[1]);
        }

        return findDuplicate(edges);
    }

    private int[] findDuplicate(int[][] edges) {
        roots = new int[edges.length + 1];

        for (int[] edge : edges) {
            if (roots[edge[1]] > 0) {
                return edge;
            }
            roots[edge[1]] = edge[0];
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
