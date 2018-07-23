package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 7/22/18 9:11 PM
 */
public class S90 {
    List<List<Integer>> ret;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ret = new ArrayList<>();
        Arrays.sort(nums);
        getSubsets(nums, 0, new ArrayList<>());
        //System.out.println(ret);
        return ret;
    }

    private void getSubsets(int[] nums, int start, List<Integer> path) {

        if (start == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }

        ret.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            getSubsets(nums, i + 1, path);
            path.remove(path.size() - 1);
        }

    }
}
