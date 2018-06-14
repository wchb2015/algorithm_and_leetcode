package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 6/13/18 4:32 PM
 */
public class S323 {

    private List<Integer>[] g;
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int count;


    public int countComponents(int n, int[][] edges) {

        //init
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        count = 0;

        // add edges 2 adjacency lists
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j + 1 < edges[i].length; j++) {
                addEdge(edges[i][j], edges[i][j + 1]);
            }
        }

        // dfs
        for (int i = 0; i < g.length; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        return count;

    }

    private void dfs(int v) {
        visited[v] = true;
        for (int i : g[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private void addEdge(int v, int w) {
        g[v].add(w);
        if (v != w) {
            g[w].add(v);
        }
    }

}
