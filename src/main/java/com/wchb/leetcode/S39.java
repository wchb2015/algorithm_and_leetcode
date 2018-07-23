package com.wchb.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/22/18 3:32 PM
 */
public class S39 {

    List<List<Integer>> ret;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new LinkedList<>());
        return ret;
    }

    private void dfs(int[] candidates, int start, int target, LinkedList<Integer> path) {

        if (target == 0) {
            System.out.println(path);
            ret.add((List<Integer>) path.clone());
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i == candidates.length || target < candidates[i]) return;
            path.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], path);
            path.removeLast();
        }

    }

}
