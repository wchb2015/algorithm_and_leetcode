package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @date 7/18/18 3:06 PM
 */
public class S261DFS {

    private int[] visited;
    List<Integer>[] list;
    int count = 0;

    public boolean validTree(int n, int[][] edges) {
        init(n, edges);

        for (int v = 0; v < n; v++) {
            if (visited[v] == 1) continue;
            if (hasCycle(v, null)) return false;
            count++;
        }

        return count == 1;
    }

    private boolean hasCycle(int v, Integer parent) {
        visited[v] = 1;

        for (Integer adj : list[v]) {
            if (adj.equals(parent)) continue;
            if (visited[adj] == 1) return true;
            if (hasCycle(adj, v)) return true;
        }
        return false;
    }

    private void init(int v, int[][] edges) {
        visited = new int[v];
        list = new List[v];

        for (int i = 0; i < v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            list[v1].add(v2);
            list[v2].add(v1);
        }
    }
}
