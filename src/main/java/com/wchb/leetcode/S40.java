package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/22/18 6:38 PM
 */
public class S40 {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new LinkedList<>());
        return ans;
    }

    private void dfs(int[] candidates, int index, int target, LinkedList<Integer> path) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (i > 0 && candidates[i] == candidates[i - 1]) {
                System.out.println(i + "-----" + index + "---" + path + " continue: " + (i > index));
            }


            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) return;
            path.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], path);
            path.removeLast();
        }
    }
}
