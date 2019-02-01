package com.wchb.leetcode;

import java.util.*;

/**
 * @date 2/1/19 10:51 AM
 */
public class S301 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) return Collections.emptyList();

        List<Set<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) g.add(new HashSet<>());
        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (g.get(i).size() == 1) leaves.add(i);
        }


        while (n > 2) {
            n = n - leaves.size();

            List<Integer> newLeaves = new LinkedList<>();
            for (int v : leaves) {
                Set<Integer> neis = g.get(v);
                for (Integer nei : neis) {
                    g.get(nei).remove(v);
                    if (g.get(nei).size() == 1) {
                        newLeaves.add(nei);
                    }
                }

            }
            leaves = newLeaves;
        }


        return leaves;
    }

    private int bfs(int v, Map<Integer, List<Integer>> g) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        Set<Integer> visited = new HashSet<>();
        visited.add(v);

        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int levelCount = q.size();

            for (int i = 0; i < levelCount; i++) {
                Integer cur = q.poll();
                for (Integer nei : g.get(cur)) {
                    if (visited.contains(nei)) continue;
                    q.offer(nei);
                    visited.add(nei);
                }
            }
        }

        return level;
    }

    private void buildGraph(int n, int[][] edges, Map<Integer, List<Integer>> g) {
        for (int i = 0; i < n; i++) g.put(i, new LinkedList<>());

        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
    }
}
