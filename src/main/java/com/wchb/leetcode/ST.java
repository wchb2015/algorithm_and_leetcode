package com.wchb.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @date 12/29/18 12:27 PM
 */
public class ST {
    public int calculateMinimumHP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        grid[m - 1][n - 1] = grid[m - 1][n - 1] > 0 ? 1 : 1 - (grid[m - 1][n - 1]);
        for (int i = n - 2; i >= 0; i--)
            grid[m - 1][i] = grid[m - 1][i] >= grid[m - 1][i + 1] ? 0 : grid[m - 1][i + 1] - grid[m - 1][i];
        for (int i = m - 2; i >= 0; i--)
            grid[i][n - 1] = grid[i][n - 1] >= grid[i + 1][n - 1] ? 0 : grid[i + 1][n - 1] - grid[i][n - 1];

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int godownIncoming = grid[i][j] >= grid[i + 1][j] ? 0 : grid[i + 1][j] - grid[i][j];
                int gorightIncoming = grid[i][j] >= grid[i][j + 1] ? 0 : grid[i][j + 1] - grid[i][j];
                grid[i][j] = Math.min(godownIncoming, gorightIncoming);
            }
        }
        return grid[0][0];
    }
}
