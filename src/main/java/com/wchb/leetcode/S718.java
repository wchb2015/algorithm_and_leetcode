package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 7/26/18 12:51 PM
 */
public class S718 {

    private int[][] memo;
    private int max = 0;

    public int findLength(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;

        if (m == 0 || n == 0) return 0;
        if (m == n && n == 1) return A[0] == B[0] ? 1 : 0;

        memo = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println(A[i - 1] + "----" + B[j - 1]);
                if (A[i - 1] == B[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    max = Math.max(memo[i][j], max);
                }

            }
            System.out.println(Arrays.toString(memo[i - 1]));
        }

        return max;
    }

}
