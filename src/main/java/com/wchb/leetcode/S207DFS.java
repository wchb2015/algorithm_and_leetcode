package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 7/17/18 3:23 PM
 */
public class S207DFS {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n = prerequisites.length;
        if (n <= 1) return true;
        Graph g = new Graph(numCourses);

        // build Graph
        for (int[] edge : prerequisites) {
            g.addEdge(edge[1], edge[0]);
        }

        boolean[] onPath = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && dfs(g, i, onPath, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Graph g, int v, boolean[] onPath, boolean[] visited) {
        if (visited[v]) return false;
        if (onPath[v]) return true;

        visited[v] = true;
        onPath[v] = true;

        for (Integer nei : g.getAllConnectedVertices(v)) {
            if (onPath[nei] || dfs(g, nei, onPath, visited)) {
                return true;
            }
        }

        onPath[v] = false;
        return false;
    }


    class Graph {
        private int v;

        private List<Integer>[] g;

        public Graph(int v) {
            this.v = v;
            g = new List[v];
            for (int i = 0; i < v; i++) {
                g[i] = new ArrayList<>();
            }
        }

        public List<Integer> getAllConnectedVertices(int v) {
            return g[v];
        }

        public void addEdge(int from, int to) {
            g[from].add(to);
        }

    }
}
