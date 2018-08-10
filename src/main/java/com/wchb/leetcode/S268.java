package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 8/9/18 10:14 PM
 */
public class S268 {
    public int missingNumber(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) return i;
        }

        return nums.length;
    }
}
