package com.wchb.leetcode;

/**
 * @date 7/25/18 10:47 AM
 */
public class S213 {

    //先求出第一家到倒数第二家的最大钱财数量
    //然后求出第二家到最后一家的最大钱财数量
    //最后求两者的较大值
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        int[] dp2 = new int[n];
        dp2[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 1; i--) {
            //memo[i]
            for (int j = i; j < n; j++) {
                dp2[i] = Math.max(dp2[i], nums[j] + (j + 2 < n ? dp2[j + 2] : 0));
            }
        }

        return Math.max(dp[n - 2], dp2[1]);
    }
}
