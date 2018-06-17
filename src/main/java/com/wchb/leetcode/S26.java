package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

import java.util.Set;
import java.util.TreeSet;

/**
 * @date 6/16/18 11:59 AM
 */
public class S26 {

    @CreatedByMyself
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new TreeSet<>();
        int l = 0;// l=去重后数组的length
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            } else {
                set.add(nums[i]);
                nums[l++] = nums[i];
            }
        }

        return l;
    }

    public int removeDuplicatesV2(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int i = 0;//指向去重后数组的最后一个元素
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                continue;
            } else {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

}
