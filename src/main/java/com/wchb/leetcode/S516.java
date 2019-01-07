package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 8/9/18 2:06 PM
 */
public class S516 {


    public int longestPalindromeSubseq(String s) {

        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;

            for (int j = i + 1; j < n; j++) {
                System.out.println(i + "----" + j);
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[0][n - 1];
    }
}
