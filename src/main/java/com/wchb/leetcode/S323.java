package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 6/13/18 4:32 PM
 */
public class S323 {

    int count = 0;
    List<Integer>[] g;
    int[] visited;

    public int countComponents(int n, int[][] edges) {
        g = new List[n];
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        for (int v = 0; v < n; v++) {
//            dfs(v);
//            count++;
            if (visited[v] != 1) {
                dfs(v);
                count++;
            }
        }

        return count;
    }

    private void dfs(int v) {
        if (visited[v] == 1) return;
        visited[v] = 1;
        for (Integer nei : g[v]) {
            if (visited[nei] == 1) continue;
            dfs(nei);
        }
    }

}
