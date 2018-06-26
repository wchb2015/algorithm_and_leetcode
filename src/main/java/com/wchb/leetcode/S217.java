package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 6/18/18 2:33 PM
 */


public class S217 {

    //time complexity o(1)
    //space complexity o(n)
    @CreatedByMyself
    public boolean containsDuplicate(int[] nums) {

        if (nums.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }
}
