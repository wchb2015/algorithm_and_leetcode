package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 7/25/18 5:41 PM
 */
public class S300 {


    //递归+记忆
    int[] memo;

    public int lengthOfLIS(int[] nums) {

        memo = new int[nums.length];

        int n = nums.length;
        if (n <= 1) return n;

        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, getMaxLength(nums, i));
        }
        return ans;
    }

    private int getMaxLength(int[] nums, int start) {
        if (memo[start] != 0) return memo[start];
        int ans = 1;
        for (int i = 0; i <= start - 1; i++) {
            if (nums[i] < nums[start]) {
                ans = Math.max(ans, 1 + getMaxLength(nums, i));
            }
        }
        memo[start] = ans;
        return ans;
    }

    /************************************************************/
    //DP
    //T:O(n^2)
    public int lengthOfLISV2(int[] nums) {

        int n = nums.length;
        if (n <= 1) return n;

        // mem[i]表示以nums[i]为结尾的最长上升子序列的长度
        int[] mem = new int[n];
        Arrays.fill(mem, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
        }

        Arrays.sort(mem);
        return mem[n - 1];
    }

}
