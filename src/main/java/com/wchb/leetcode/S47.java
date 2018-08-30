package com.wchb.leetcode;

import java.util.*;

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

    /************************************************************/
    // Time complexity: O(n!)
    // Space complexity: O(n + k)
    public List<List<Integer>> permuteUniqueV2(int[] nums) {
        ret = new LinkedList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);

        dfsV2(nums, new LinkedList<>());
        return ret;
    }

    private void dfsV2(int[] nums, LinkedList<Integer> ans) {
        if (ans.size() == nums.length) {
            ret.add((List<Integer>) ans.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // Same number can be only used once at each depth.
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue;

            used[i] = true;
            ans.add(nums[i]);
            dfsV2(nums, ans);
            ans.removeLast();
            used[i] = false;
        }
    }

}
