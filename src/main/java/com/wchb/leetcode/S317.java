package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 1/22/19 1:13 PM
 */
public class S317 {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        int buildings = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) buildings++;
            }
        }

        int[][] hit = new int[m][n];
        int[][] distSum = new int[m][n];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 1)
                    bfs(i, j, grid, hit, distSum, buildings, m, n);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 0 && hit[i][j] == buildings)
                    res = Math.min(res, distSum[i][j]);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(int r, int c, int[][] grid, int[][] hit, int[][] distSum, int buildings, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        int countOne = 0;
        int dist = 0;

        q.add(new Pair(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            dist++;
            int levelCount = q.size();
            while (levelCount > 0) {
                levelCount--;
                Pair cur = q.poll();

                for (int[] dir : dirs) {
                    int nextR = cur.x + dir[0];
                    int nextC = cur.y + dir[1];
                    if (!isValid(nextR, nextC, grid) ||
                            visited[nextR][nextC] || grid[nextR][nextC] != 0) continue;

                    q.add(new Pair(nextR, nextC));
                    visited[nextR][nextC] = true;
                    hit[nextR][nextC]++;
                    distSum[nextR][nextC] += dist;
                }
            }
        }
    }

    private boolean isValid(int r, int c, int[][] image) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
            return false;
        }
        return true;
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
