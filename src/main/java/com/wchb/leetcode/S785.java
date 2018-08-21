package com.wchb.leetcode;

/**
 * @date 8/20/18 4:52 PM
 */
public class S785 {

    private int[] colors;//0 unknown 1 red -1 blue

    public boolean isBipartite(int[][] graph) {


        int n = graph.length;

        colors = new int[n];

        for (int node = 0; node < n; node++) {
            if (colors[node] == 0 && !dfs(graph, node, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int cur, int color) {
        colors[cur] = color;
        for (int node : graph[cur]) {
            if (colors[node] == color) return false;
            if (colors[node] == 0 && !dfs(graph, node, -color)) return false;
        }

        return true;
    }
}
