package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/19/18 3:18 PM
 */
public class S448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ret = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) nums[i] -= 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1 || nums[nums[i]] == -1) continue;
            int ele = nums[i];
            while (nums[ele] != -1) {
                int temp = nums[ele];
                nums[ele] = -1;
                ele = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                ret.add(i + 1);
            }
        }

        return ret;

    }
}
