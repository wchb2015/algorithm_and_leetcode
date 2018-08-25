package com.wchb.leetcode;

/**
 * @date 8/24/18 10:35 AM
 */
public class S221 {

    int m, n;
    int ans = 0;

    public int maximalSquare(char[][] matrix) {

        m = matrix.length;
        if (m == 0) return 0;
        n = matrix[0].length;
        if (n == 0) return 0;


        int[][] sum = new int[m][n];
        // sum[x][y] = sum(matrix[0][0]~matrix[x][y]);
        sum[0][0] = Character.getNumericValue(matrix[0][0]);

        for (int x = 1; x < m; x++) sum[x][0] = sum[x - 1][0] + matrix[x][0] - '0';
        for (int y = 1; y < n; y++) sum[0][y] = sum[0][y - 1] + matrix[0][y] - '0';

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                sum[x][y] = sum[x - 1][y] + sum[x][y - 1] - sum[x - 1][y - 1] + Character.getNumericValue(matrix[x][y]);
            }
        }

        return ans;
    }
}
