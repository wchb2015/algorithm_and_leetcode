package com.wchb.leetcode;

/**
 * @date 7/24/18 4:11 PM
 */
public class S63 {

    int[][] ways;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean hasObsX = false;
        boolean hasObsY = false;
        ways = new int[m][n];
        if (obstacleGrid[0][0] == 1) return 0;

        ways[0][0] = 1;

        for (int x = 1; x < m; x++) {
            hasObsX = (obstacleGrid[x][0] == 1) || hasObsX;
            ways[x][0] = hasObsX ? 0 : 1;
        }

        for (int y = 1; y < n; y++) {
            hasObsY = (obstacleGrid[0][y] == 1) || hasObsY;
            ways[0][y] = hasObsY ? 0 : 1;
        }

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                ways[x][y] = (obstacleGrid[x][y] == 1) ? 0 : ways[x - 1][y] + ways[x][y - 1];
            }
        }

        return ways[m - 1][n - 1];
    }
}
