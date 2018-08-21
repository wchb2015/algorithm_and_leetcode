package com.wchb.leetcode;


import java.util.LinkedList;

/**
 * @date 8/20/18 4:28 PM
 */
public class S886 {

    private LinkedList<Integer>[] g;

    private int[] colors;//0 unknown 1 red -1 blue


    public boolean possibleBipartition(int N, int[][] dislikes) {


        buildGraph(N, dislikes);
        colors = new int[N];

        for (int node = 0; node < N; node++) {
            if (colors[node] == 0 && !dfs(node, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int cur, int color) {

        colors[cur] = color;
        for (Integer node : g[cur]) {
            if (colors[node] == color) return false;
            if (colors[node] == 0 && !dfs(node, -color)) return false;
        }

        return true;
    }

    private void buildGraph(int n, int[][] dislikes) {

        g = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }

        for (int[] edge : dislikes) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
    }
}
