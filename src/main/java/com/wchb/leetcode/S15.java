package com.wchb.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 6/18/18 9:18 AM
 */

// Using two pointer technique
// Time Complexity: O(n^2)
// Space Complexity: O(n)
public class S15 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new LinkedList<>();
        Arrays.sort(nums);

        int index = 0;

        while (index < nums.length - 2) {
            if (nums[index] > 0) break;

            int start = index + 1;
            int end = nums.length - 1;

            while (start < end) {
                if (nums[start] + nums[end] == -nums[index]) {
                    ret.add(Arrays.asList(nums[index], nums[start], nums[end]));
                    // continue to look for other pairs
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    start++;
                    while (end > start && nums[end] == nums[end - 1]) end--;
                    end--;
                } else if (nums[start] + nums[end] < -nums[index]) {
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    start++;
                } else {
                    while (end > start && nums[end] == nums[end - 1]) end--;
                    end--;
                }
            }

            while (index < nums.length - 2 && nums[index] == nums[index + 1]) index++;
            index++;
        }

        return ret;
    }


}
