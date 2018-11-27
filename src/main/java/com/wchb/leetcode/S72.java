package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 9/6/18 10:40 AM
 */
public class S72 {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        memo = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            Arrays.fill(memo[i], -1);
        }

        return minDistance(word1, word2, len1 - 1, len2 - 1);
    }


    private int minDistance(String word1, String word2, int idx1, int idx2) {
        if (idx1 < 0) return idx2 + 1;
        if (idx2 < 0) return idx1 + 1;


        if (memo[idx1][idx2] != -1) return memo[idx1][idx2];

        int ans;
        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            ans = minDistance(word1, word2, idx1 - 1, idx2 - 1);
        } else {
            ans = Math.min(minDistance(word1, word2, idx1 - 1, idx2 - 1), Math.min(minDistance(word1, word2, idx1, idx2 - 1), minDistance(word1, word2, idx1 - 1, idx2))) + 1;
        }

        memo[idx1][idx2] = ans;
        return ans;
    }
    //https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)/192017

    /************************************************************/
    public int minDistanceV2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]),
                            dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
