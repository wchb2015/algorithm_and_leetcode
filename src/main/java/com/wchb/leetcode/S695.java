package com.wchb.leetcode;

/**
 * @date 8/9/18 5:26 PM
 */
public class S695 {

    int m = 0;
    int n = 0;
    int area = 0;
    int ret = 0;

    int[][] visited = null;

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    area = 0;
                    dfs(grid, i, j);
                    ret = Math.max(ret, area);
                }
            }
        }

        return ret;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (!inArea(x, y) || visited[x][y] == 1 || grid[x][y] == 0) {
            return;
        }
        visited[x][y] = 1;
        area++;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
