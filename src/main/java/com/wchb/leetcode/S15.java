package com.wchb.leetcode;

import java.util.*;

/**
 * @date 6/18/18 9:18 AM
 */
public class S15 {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<Integer> integerSet = new TreeSet<>();
        List<List<Integer>> ret = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            integerSet.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                int target = 0 - nums[i] - nums[j];
                if (integerSet.contains(target)) {
                    if (target == nums[i] && target == nums[j]) {
                        continue;
                    }
                    ret.add(Arrays.asList(target, nums[i], nums[j]));
                }
            }
        }

        return ret;
    }

}
