package com.wchb.leetcode;

/**
 * @date 8/25/18 7:41 AM
 */
public class S59 {
    public int[][] generateMatrix(int n) {

        int[] arr = new int[n * n + 1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        int[][] ret = new int[n][n];

        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;

        // Until it reach the spiral center that is rowStart > rowEnd or colStart > colEnd
        int k = 1;
        while (true) {
            // Right
            for (int j = colStart; j <= colEnd; j++) {
                ret[rowStart][j] = arr[k++];
            }
            rowStart++;
            if (rowStart > rowEnd) break;

            // Down
            for (int i = rowStart; i <= rowEnd; i++) {
                ret[i][colEnd] = arr[k++];
            }
            colEnd--;
            if (colStart > colEnd) break;

            // Left
            for (int j = colEnd; j >= colStart; j--) {
                ret[rowEnd][j] = arr[k++];
            }
            rowEnd--;
            if (rowStart > rowEnd) break;

            // Up
            for (int i = rowEnd; i >= rowStart; i--) {
                ret[i][colStart] = arr[k++];
            }
            colStart++;
            if (colStart > colEnd) break;
        }

        return ret;

    }
}
