package com.wchb.leetcode;

import java.util.List;

/**
 * @date 6/13/18 4:32 PM
 */
public class S323 {

    private int n;  // 节点数
    private List<Integer>[] g; // 图的具体数据
    private boolean directed = false;

    public int countComponents(int n, int[][] edges) {
        this.n = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                addEdge(i, j);
            }
        }

        return 1;

    }

    public void addEdge(int v, int w) {
        if (v >= 0 && v < n && w >= 0 && w < n) {
            g[v].add(w);
            if (v != w && !directed) {
                g[w].add(v);
            }
        }
    }


}
