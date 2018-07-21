package com.wchb.leetcode;

import java.util.*;

/**
 * @date 7/19/18 8:52 PM
 */


// DFS
// For each edge (u, v),
// traverse the graph with a depth-first search to see
// if we can connect u to v.
// If we can, then it must be the duplicate edge.
public class S684 {

    List<Integer>[] g;
    Set<Integer> visited = new HashSet();

    public int[] findRedundantConnection(int[][] edges) {
        g = new List[edges.length + 1];
        for (int i = 1; i < edges.length + 1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            visited.clear();
            if (!g[edge[0]].isEmpty() && !g[edge[1]].isEmpty()
                    && hasPath(edge[0], edge[1])) return edge;

            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
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
