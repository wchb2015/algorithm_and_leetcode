package com.wchb.leetcode;

/**
 * @date 8/7/18 12:30 PM
 */
public class S494 {
    int ret = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, S);
        return ret;
    }


    private void dfs(int[] nums, int index, int S) {
        if (index == nums.length) {
            if (S == 0) ret++;

            return;
        }
        dfs(nums, index + 1, S + nums[index]);
        dfs(nums, index + 1, S - nums[index]);
    }
}
