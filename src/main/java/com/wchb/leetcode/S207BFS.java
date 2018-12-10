package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 12/9/18 10:54 PM
 */
public class S207BFS {


    // TC:
    // SC:
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n = prerequisites.length;
        if (n <= 1) return true;
        Graph g = new Graph(numCourses);

        // build Graph
        for (int[] edge : prerequisites) {
            g.addEdge(edge[1], edge[0]);
        }

        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // edge[0] to
        // edge[1] from
        while (!queue.isEmpty()) {
            int from = queue.poll();
            numCourses--;
            for (int[] edge : prerequisites) {
                if (edge[1] == from) {
                    inDegree[edge[0]]--;
                    if (inDegree[edge[0]] == 0) {
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        return numCourses == 0;
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
