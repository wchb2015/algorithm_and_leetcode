package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 7/17/18 3:23 PM
 */
public class S207 {

    private SparseGraph graph;
    private boolean isDAG;
    //标记矩阵,0为当前结点未访问,1为访问过,-1表示当前结点后边的结点都被访问过。
    private int[] visited;
    private int v;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        v = numCourses;
        graph = new SparseGraph(v);
        isDAG = true;
        visited = new int[v];

        init(prerequisites);
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return isDAG;
    }

    private void init(int[][] edges) {
        for (int[] edge : edges) {
            graph.addEdge(edge[1], edge[0]);
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

        private List<Integer>[] g;//图中的数据

        public SparseGraph(int v) {
            this.v = v;
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

    /************************************************************/
    // BFS
    // 1-------------->0
    // [0,1]:to take course 0 you have to first take course 1
    // edge[0] in
    // edge[1] out
    public boolean canFinishV2(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int res = numCourses;
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                System.out.println("Order: " + i);
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int in = queue.poll();
            res--;
            for (int[] edge : prerequisites) {
                if (edge[1] == in) {
                    inDegree[edge[0]]--;
                    if (inDegree[edge[0]] == 0) {
                        System.out.println("Order: " + edge[0]);
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        return res == 0;
    }

}
