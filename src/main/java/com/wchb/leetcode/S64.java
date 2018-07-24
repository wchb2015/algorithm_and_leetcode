package com.wchb.leetcode;

/**
 * @date 7/23/18 6:10 PM
 */
public class S64 {
    int m, n;
    int[][] mem;

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        mem = new int[m][n];

        return min(0, 0, grid);
    }


    private int min(int x, int y, int[][] grid) {
        x = x > m - 1 ? m - 1 : x;
        y = y > n - 1 ? n - 1 : y;
        if (mem[x][y] != 0) {
            return mem[x][y];
        }
        int ret;
        if (x == m - 1 && y == n - 1) {
            ret = grid[m - 1][n - 1];
        } else if (x == m - 1) {
            ret = grid[m - 1][y] + min(m - 1, y + 1, grid);
        } else if (y == n - 1) {
            ret = grid[x][n - 1] + min(x + 1, n - 1, grid);
        } else {
            ret = Math.min(min(x, y + 1, grid), min(x + 1, y, grid)) + grid[x][y];
        }
        mem[x][y] = ret;
        return ret;
    }
}
