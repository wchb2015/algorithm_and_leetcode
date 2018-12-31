package com.wchb.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @date 12/29/18 12:27 PM
 */
public class ST {
    public int findUnsortedSubarray(int[] nums) {
        int[] nums2 = nums.clone();

        Arrays.sort(nums2);
        int l = 0;
        int r = nums.length - 1;

        while (l < r && nums2[l] == nums[l] && nums2[r] == nums[r]) {
            l++;
            r--;
        }

        return r - l + 1;
    }
}
