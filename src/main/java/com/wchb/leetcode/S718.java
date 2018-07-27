package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 7/26/18 12:51 PM
 */
public class S718 {

    private int[][] memo;

    public int findLength(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;

        if (m == 0 || n == 0) return 0;
        if (m == n && n == 1) return A[0] == B[0] ? 1 : 0;

        memo = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(memo[i], -1);
        //LCS(m,n) S1[0...m] And S2[0..n]的最长公共子序列的长度.
        //if(S1[m]==S2[n]) LCS(m,n) = 1 + LCS(m-1,n-1);
        //else LCS(m,n)= Math.max(LCS(m-1,n),LCS(m,n-1));
        return lcs(A, B, m - 1, n - 1);
    }


    // 求s1[0...m]和s2[0...n]的最长公共子序列的长度值
    private int lcs(int[] A, int[] B, int m, int n) {
        if (m < 0 || n < 0) return 0;
        if (memo[m][n] != -1) return memo[m][n];

        int res;
        if (A[m] == B[n])
            res = 1 + lcs(A, B, m - 1, n - 1);
        else
            res = Math.max(lcs(A, B, m - 1, n),
                    lcs(A, B, m, n - 1));

        memo[m][n] = res;
        return res;
    }
}
