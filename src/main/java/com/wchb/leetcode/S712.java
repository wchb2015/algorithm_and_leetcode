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
}
