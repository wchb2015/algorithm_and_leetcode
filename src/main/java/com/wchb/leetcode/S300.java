package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 7/25/18 5:41 PM
 */
public class S300 {

    //T:O(n^2)
    public int lengthOfLIS(int[] nums) {

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

        System.out.println(Arrays.toString(mem));

        Arrays.sort(mem);
        return mem[n - 1];
    }

}
