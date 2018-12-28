package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 7/25/18 9:17 PM
 */
public class S322 {


    //DP
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];

    }

}
