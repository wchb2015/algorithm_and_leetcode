package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 7/19/18 8:52 PM
 */
public class S684 {
    private int[] visited;
    List<Integer>[] list;
    int v;

    public int[] findRedundantConnection(int[][] edges) {
        buildGraph(edges);
        return findCycle(0, null);
    }

    private int[] findCycle(int v, Integer from) {

        visited[v] = 1;
        for (Integer adj : list[v]) {
            if (adj.equals(from)) continue;
            if (visited[adj] == 1) {
                System.out.println(adj + "---" + from);
                return new int[]{v + 1, from + 1};
            }
            return findCycle(adj, v);
        }
        return null;
    }


    private void buildGraph(int[][] edges) {
        v = edges.length;
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
