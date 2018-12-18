package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 12/17/18 3:12 PM
 */
public class S41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int p = 0;
        while (p < n && nums[p] <= 0) {
            p++;
        }
        if (p == n - 1) return nums[p] == 1 ? 2 : 1;

        int start = 1;
        while (p < n) {
            System.out.println(p);
            if (nums[p] != start) {
                return start;
            } else {
                p++;
                start++;
            }
        }
        if (p == n - 1) return start + 1;
        return start;
    }
}
