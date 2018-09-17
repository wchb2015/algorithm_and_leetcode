package com.wchb.leetcode;

/**
 * @date 8/20/18 4:52 PM
 */
public class S785 {


    //Our goal is trying to use two colors to color the graph and see if any adjacent nodes having the same color.
    //For each node
    // If it hasn't been colored, use a color to color it.Then use the other color to color all its adjacent nodes[dfs]
    // If it has been colored,check if the current color is the same as the color that is going to be used to color it.
    // if yes return false;
    private int[] colors;//  0 uncolored red 1 blue -1

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue;
            if (!dfs(graph, i, 1)) return false;
        }

        return true;
    }

    private boolean dfs(int[][] graph, int cur, int color) {

        colors[cur] = color;
        int[] neis = graph[cur];
        for (int nei : neis) {
            if (colors[nei] == color) return false;
            if (colors[nei] == 0 && !dfs(graph, nei, -color)) return false;
        }

        return true;
    }
}
