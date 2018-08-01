package com.wchb.leetcode;


import java.util.LinkedList;
import java.util.List;

/**
 * @date 6/21/18 2:34 PM
 */
public class S46 {


    //T:O(n^n)
    //S:o(n)
    List<List<Integer>> ret;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        ret = new LinkedList<>();
        used = new boolean[nums.length];
        dfs(nums, new LinkedList<>());
        return ret;
    }

    private void dfs(int[] nums, LinkedList<Integer> ans) {
        if (ans.size() == nums.length) {
            ret.add((List<Integer>) ans.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                ans.add(nums[i]);
                dfs(nums, ans);
                ans.removeLast();
                used[i] = false;
            } else {
                continue;
            }
        }
    }
}
