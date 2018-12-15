package com.wchb.leetcode;

/**
 * @date 12/14/18 11:39 AM
 */
public class S518 {

    //DP
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int k = 1; k < dp.length; k++) {
                if (k >= coin) {
                    dp[k] += dp[k - coin];
                }
            }
        }

        return dp[amount];
    }
}
