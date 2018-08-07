package com.wchb.leetcode;

/**
 * @date 8/6/18 7:12 AM
 */
public class S503 {
    public int[] nextGreaterElements(int[] nums) {

        int length = nums.length;
        int[] ret = new int[nums.length];

        for (int i = 0; i < length; i++) {
            int offset = 0;
            int j = i;
            while (offset < length) {
                if (nums[(j + offset) % length] > nums[i]) {
                    ret[i] = nums[(j + offset) % length];
                    break;
                }
                offset++;
            }
            if (offset == length) {
                ret[i] = -1;
            }
        }

        return ret;

    }
}
