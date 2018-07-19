package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 7/17/18 3:23 PM
 */
public class S207 {

    private SparseGraph graph = null;
    boolean isDAG = true;
    //标记矩阵,0为当前结点未访问,1为访问过,-1表示当前结点后边的结点都被访问过。
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        init(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return isDAG;
    }

    private void init(int v, int[][] edges) {
        graph = new SparseGraph(v, true);
        visited = new int[v];

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j + 1 < edges[0].length; j++) {
                graph.addEdge(edges[i][j], edges[i][j + 1]);
            }
        }
    }

    private void dfs(int i) {
        if (visited[i] != 0) return;
        visited[i] = 1;
        List<Integer> list = graph.getAllConnectedVertices(i);
        for (Integer k : list) {
            if (visited[k] == 1) {
                isDAG = false;
                break;
            } else if (visited[k] == -1) {
                continue;
            } else {
                dfs(k);
            }
        }
        visited[i] = -1;
    }

    private class SparseGraph {
        private int v;//节点数
        private boolean isDirected;

        private List<Integer>[] g;//图中的数据

        public SparseGraph(int v, boolean isDirected) {
            this.v = v;
            this.isDirected = isDirected;
            g = (List<Integer>[]) new List[v];
            for (int i = 0; i < v; i++) {
                g[i] = new ArrayList<>();
            }
        }

        public void addEdge(int i, int w) {
            g[i].add(w);
        }

        public List<Integer> getAllConnectedVertices(int v) {
            assert v >= 0 && v < graph.v;
            return graph.g[v];
        }
    }

}
