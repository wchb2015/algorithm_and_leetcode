package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 12/15/18 3:04 PM
 */
public class S743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N];
        Arrays.fill(dist, -1);
        dist[K - 1] = 0;

        for (int k = 0; k < N - 1; k++) {
            for (int[] edge : times) {
                int u = edge[0] - 1;
                int v = edge[1] - 1;
                int t = edge[2];

                if (dist[u] == -1) continue;
                if (dist[v] == -1 || dist[u] + t < dist[v]) {
                    dist[v] = dist[u] + t;
                }
            }
        }

        int max = 0;
        for (int u = 0; u < N; u++) {
            if (dist[u] == -1) return -1;
            if (dist[u] > max) max = dist[u];
        }
        return max;
    }
}
