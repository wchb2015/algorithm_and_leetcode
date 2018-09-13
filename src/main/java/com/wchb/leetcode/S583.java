package com.wchb.leetcode;

/**
 * @date 9/12/18 1:30 PM
 */
public class S583 {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        memo = new int[l1 + 1][l2 + 1];

        return minDistance(word1, word2, l1, l2);
    }

    private int minDistance(String word1, String word2, int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (memo[i][j] != 0) return memo[i][j];
        int ans = Integer.MAX_VALUE;
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            ans = minDistance(word1, word2, i - 1, j - 1);
        } else {
            ans = Math.min(minDistance(word1, word2, i, j - 1), minDistance(word1, word2, i - 1, j)) + 1;
        }
        memo[i][j] = ans;

        return ans;
    }
}
