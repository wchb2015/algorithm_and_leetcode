package com.wchb.leetcode;

/**
 * @date 7/11/18 1:42 PM
 */
public class S200V2 {

    int m = 0;
    int n = 0;

    int[][] visited = null;

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (!inArea(x, y) || visited[x][y] == 1 || grid[x][y] == '0') {
            return;
        }
        visited[x][y] = 1;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
