package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @date 9/14/18 2:31 PM
 */
public class S685 {
    List<Integer>[] g;
    Set<Integer> visited = new HashSet();

    public int[] findRedundantDirectedConnection(int[][] edges) {
        g = new List[edges.length + 1];
        for (int i = 1; i < edges.length + 1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            visited.clear();

            int from = edge[0];
            int to = edge[1];
            if (!g[from].isEmpty() && !g[to].isEmpty() && hasPath(from, to)) {
                return edge;
            }

            g[edge[0]].add(edge[1]);
        }

        return null;
    }

    private boolean hasPath(int from, int to) {

        visited.add(from);

        for (int nei : g[from]) {
            if (visited.contains(nei)) {
                continue;
            }
            if (nei == to) {
                return true;
            }
            if (hasPath(nei, to)) {
                return true;
            }
        }
        return false;
    }
}
