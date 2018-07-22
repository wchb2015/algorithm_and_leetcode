package com.wchb.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @date 7/22/18 9:00 AM
 */
public class S47 {
    List<List<Integer>> ret;
    boolean[] used;
    Set<String> pathSet;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ret = new LinkedList<>();
        used = new boolean[nums.length];
        pathSet = new HashSet<>();
        dfs(nums, new LinkedList<>(), "");
        return ret;
    }

    private void dfs(int[] nums, LinkedList<Integer> ans, String path) {
        if (pathSet.contains(path)) return;
        if (ans.size() == nums.length) {
            ret.add((List<Integer>) ans.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                pathSet.add(path);
                used[i] = true;
                ans.add(nums[i]);
                dfs(nums, ans, path + nums[i]);
                ans.removeLast();
                used[i] = false;
            } else {
                continue;
            }
        }
    }
}
