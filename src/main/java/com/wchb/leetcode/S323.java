package com.wchb.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 6/13/18 4:32 PM
 */
public class S323 {

    List<Integer>[] g;
    int ans;
    boolean[] visited;

    public int countComponents(int n, int[][] edges) {
        g = new List[n];
        ans = 0;
        visited = new boolean[n];


        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(g, i);
            ans++;
        }

        return ans;
    }

    private void dfs(List<Integer>[] g, int v) {
        if (visited[v]) return;
        visited[v] = true;
        List<Integer> adjs = g[v];
        for (Integer adj : adjs) {
            if (visited[adj]) continue;
            dfs(g, adj);
        }
    }

    /************************************************************/

    public int countComponentsV2(int n, int[][] edges) {

        UF uf = new UF(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.size();
    }


    private class UF {
        int size;
        int[] parent;

        public UF(int size) {
            this.size = size;
            parent = new int[size];
            Arrays.fill(parent, -1);
        }

        private int find(int i) {
            return parent[i] == -1 ? i : parent[i];
        }

        public void union(int i, int j) {

            int iId = find(i);
            int jId = find(j);
            if (iId == jId) return;

            for (int k = 0; k < size; k++) {
                if (find(k) == iId) {
                    parent[k] = jId;
                }
            }
        }

        public int size() {
            int ret = 0;
            for (int i : parent) if (i == -1) ret++;
            return ret;
        }
    }
}
