package com.wchb.leetcode;


/**
 * @date 6/22/18 2:37 PM
 */
public class S198 {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }


    public int robV2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];


        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);
        int ans = Math.max(prev1, prev2);

        for (int i = 2; i < n; i++) {
            ans = Math.max(prev1 + nums[i], prev2);
            prev1 = prev2;
            prev2 = ans;
        }

        return ans;
    }


}
