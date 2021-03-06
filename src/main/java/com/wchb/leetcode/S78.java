package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 7/13/18 2:11 PM
 */
public class S78 {

    List<List<Integer>> ret;

    public List<List<Integer>> subsets(int[] nums) {
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
            path.add(nums[i]);
            getSubsets(nums, i + 1, path);
            path.remove(path.size() - 1);
        }

    }
}
