package com.wchb.leetcode;

/**
 * @date 7/24/18 3:29 PM
 */
public class S62 {
    int[][] ways;

    public int uniquePaths(int m, int n) {
        ways = new int[m][n];
        m -= 1;
        n -= 1;

        ways[0][0] = 1;
        for (int x = 1; x <= m; x++) {
            ways[x][0] = 1;
        }

        for (int y = 1; y <= n; y++) {
            ways[0][y] = 1;
        }

        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                ways[x][y] = ways[x - 1][y] + ways[x][y - 1];
            }
        }

        return ways[m][n];
    }
}
