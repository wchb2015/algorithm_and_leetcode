package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 9/9/18 6:16 PM
 */
public class S377 {
    int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);

        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (target < 0) return 0;
        if (dp[target] != -1) return dp[target];
        int ans = 0;
        for (int num : nums) {
            ans += helper(nums, target - num);
        }
        dp[target] = ans;
        return ans;
    }
}
