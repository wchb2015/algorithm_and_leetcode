package com.wchb.leetcode;

/**
 * @date 7/25/18 3:33 PM
 */
public class S416 {

    int[][] memo;

    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) return false;

        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 != 0) return false;

        //0 未计算 1. 可以 -1. 不可以
        memo = new int[nums.length][sum / 2 + 1];

        return tryPartition(nums, 0, sum / 2);
    }

    private boolean tryPartition(int[] nums, int index, int target) {

        if (target < 0) return false;
        if (target == 0) return true;
        if (index >= nums.length) {
            return target == 0;
        }

        //[2,2,3,5]
        if (memo[index][target] != 0) return memo[index][target] == 1;

        boolean res = tryPartition(nums, index + 1, target - nums[index])
                || tryPartition(nums, index + 1, target);

        memo[index][target] = res ? 1 : -1;

        return res;
    }

    /************************************************************/
    //DP
    public boolean canPartitionV2(int[] nums) {
        if (nums.length <= 1) return false;

        int n = nums.length;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 != 0) return false;

        //0 未计算 1. 可以 -1. 不可以
        boolean[] dp = new boolean[sum / 2 + 1];
        //memo[index][target] = memo[index+1][taget-nums[index]]||memo[index][target]

        int C = sum / 2;
        for (int i = 0; i <= C; i++) {
            //首先看只考虑nums[0],能否将背包填满
            dp[i] = (nums[0] == i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = C; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[C];
    }
}
