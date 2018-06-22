package com.wchb.leetcode;

/**
 * @date 6/21/18 6:13 PM
 */
public class S200 {

    //向4个方向移动的位移 上右下左
    private int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    private boolean[][] visited;
    private boolean[][] island;

    private int sum;

    public int numIslands(char[][] grid) {

        if (grid == null) {
            throw new IllegalArgumentException("grid cannot be null!");
        }

        m = grid.length;
        if (m == 0) {
            throw new IllegalArgumentException("grid cannot be empty.");
        }
        n = grid[0].length;
        if (n == 0) {
            throw new IllegalArgumentException("grid cannot be empty.");
        }

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += searchIslands(grid, i, j);
            }
        }


        return sum;
    }

    private int searchIslands(char[][] grid, int startX, int startY) {
        int ret = 0;

        return ret;
    }

}
