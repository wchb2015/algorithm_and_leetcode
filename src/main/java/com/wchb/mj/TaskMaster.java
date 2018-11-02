package com.wchb.mj;


import java.util.*;

/**
 * @date 10/30/18 5:18 PM
 */
public class TaskMaster {


    private int numOfCycle = 0;

    public int solution(int n, int[] a, int[] b) {

        int m = a.length;
        if (m == 0) return n;


        Graph g = new Graph();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> candidates = new HashSet<>();

        for (int i = 0; i < m; i++) {
            g.addEdge(b[i], a[i]);
        }

        for (Integer vertex : g.vertexs()) {
            if (!visited.contains(vertex) && !candidates.contains(vertex))
                dfs(g, vertex, visited, candidates);
        }

        return n - numOfCycle;
    }

    public void dfs(Graph graph, Integer vertex, HashSet<Integer> visited, HashSet<Integer> candidates) {

        candidates.add(vertex);
        if (graph.adj(vertex) == null) return;
        for (Integer adj : graph.adj(vertex)) {

            if (candidates.contains(adj)) {
                // visited nodes may need to revisit to build the cycle
                // so don't put visited.contains(adj) on the if condition.
                // an example is node 4
                // found cycle
                numOfCycle++;
            } else {
                dfs(graph, adj, visited, candidates);
            }
        }
        candidates.remove(vertex);
        visited.add(vertex);
    }

    private class Graph {
        private Map<Integer, List<Integer>> g; // 图的具体数据
        private HashSet<Integer> vertexs;


        public Graph() {
            g = new HashMap<>();
            vertexs = new HashSet<>();
        }

        public void addEdge(int from, int to) {
            vertexs.add(from);
            vertexs.add(to);
            if (!g.containsKey(from)) {
                g.put(from, new LinkedList<>());
            }
            g.get(from).add(to);
        }


        List<Integer> adj(Integer v) {
            return g.get(v);
        }

        public HashSet<Integer> vertexs() {
            return vertexs;
        }
    }


}
