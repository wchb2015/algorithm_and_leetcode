package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 10/29/18 6:22 PM
 */
public class S486 {
    public boolean PredictTheWinner(int[] nums) {

        if (nums.length == 1) return true;

        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            list.add(nums[i]);
        }

        int a = pickUpCoins(list);
        int b = sum - a;

        return a >= b;
    }


    public static int pickUpCoins(List<Integer> coins) {
        return helper(coins, 0, coins.size() - 1, new int[coins.size()][coins.size()]);
    }

    private static int helper(List<Integer> coins, int a, int b, int[][] dp) {
        // No coins left.
        if (a > b) return 0;
        if (dp[a][b] == 0) {
            int rA = coins.get(a) + Math.min(helper(coins, a + 2, b, dp),
                    helper(coins, a + 1, b - 1, dp));
            int rB = coins.get(b) + Math.min(helper(coins, a + 1, b - 1, dp),
                    helper(coins, a, b - 2, dp));
            dp[a][b] = Math.max(rA, rB);
        }
        return dp[a][b];
    }
}
