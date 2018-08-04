package com.wchb.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 8/3/18 2:32 PM
 */
public class S18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ret = new LinkedList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int index = i + 1;
            int threeTarget = target - nums[i];
            while (index < nums.length - 2) {

                int start = index + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int sum = nums[index] + nums[start] + nums[end];
                    if (sum == threeTarget) {
                        ret.add(Arrays.asList(nums[i], nums[index], nums[start], nums[end]));
                        // continue to look for other pairs
                        while (end > start && nums[end] == nums[end - 1]) end--;
                        end--;
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        start++;
                    } else if (sum < threeTarget) {
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
        }

        return ret;
    }

    private int next_num_index(int[] nums, int cur) {
        for (int i = cur + 1; i < nums.length; i++)
            if (nums[i] != nums[cur])
                return i;
        return nums.length;
    }

    private int pre_num_index(int[] nums, int cur) {
        for (int i = cur - 1; i >= 0; i--)
            if (nums[i] != nums[cur])
                return i;
        return -1;
    }
}
