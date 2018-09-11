package com.wchb.leetcode;

/**
 * @date 9/10/18 3:42 PM
 */
public class S376 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        return 1 + Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
    }

    private int calculate(int[] nums, int index, boolean isUp) {
        int maxCount = 0;
        for (int i = index + 1; i < nums.length; i++) {
            if ((isUp && nums[i] > nums[index]) || (!isUp && nums[i] < nums[index]))
                maxCount = Math.max(maxCount, 1 + calculate(nums, i, !isUp));
        }
        return maxCount;
    }

}
