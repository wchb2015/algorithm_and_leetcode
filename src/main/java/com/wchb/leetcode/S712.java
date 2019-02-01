package com.wchb.leetcode;

/**
 * @date 9/12/18 1:57 PM
 */
public class S712 {
    int[][] memo;

    public int minimumDeleteSum(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        memo = new int[l1 + 1][l2 + 1];

        return minDistance(word1, word2, l1, l2);
    }

    private int minDistance(String word1, String word2, int i, int j) {
        if (i == 0) return helper(word2, j - 1);
        if (j == 0) return helper(word1, i - 1);

        if (memo[i][j] != 0) return memo[i][j];
        int ans;
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            ans = minDistance(word1, word2, i - 1, j - 1);
        } else {
            int i1 = minDistance(word1, word2, i, j - 1) + word2.charAt(j - 1);
            int i2 = minDistance(word1, word2, i - 1, j) + word1.charAt(i - 1);
            ans = Math.min(i1, i2);
        }
        memo[i][j] = ans;

        return ans;
    }

    private int helper(String s, int i) {
        if (i >= s.length() || i < 0) return 0;
        int sum = 0;
        for (int j = 0; j <= i; j++) {
            sum += s.charAt(j);
        }
        return sum;
    }

    public int minimumDeleteSumV2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // base case
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            temp += word2.charAt(i - 1);
            dp[0][i] = temp;
        }

        temp = 0;
        for (int i = 1; i <= m; i++) {
            temp += word1.charAt(i - 1);
            dp[i][0] = temp;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];// do nothing
                } else {
                    dp[i][j] = Math.min(word1.charAt(i - 1) + dp[i - 1][j], word2.charAt(j - 1) + dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
