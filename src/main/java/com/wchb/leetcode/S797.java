package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 1/12/19 12:52 PM
 */
public class S797 {

    List<List<Integer>> ans;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new LinkedList<>();

        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(graph, 0, graph.length - 1, path);

        return ans;
    }

    private void dfs(int[][] graph, int start, int end, LinkedList<Integer> path) {
        if (start == end) {
            ans.add(new LinkedList<>(path));
            return;
        }

        for (int nei : graph[start]) {
            path.add(nei);
            dfs(graph, nei, end, path);
            path.removeLast();
        }
    }
}
