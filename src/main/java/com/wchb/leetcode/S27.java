package com.wchb.leetcode;

/**
 * @date 6/16/18 11:43 AM
 */
public class S27 {
    public int removeElement(int[] nums, int val) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            ret++;
            nums[ret - 1] = nums[i];
        }
        return ret;
    }
}
