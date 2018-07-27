package com.wchb.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/25/18 9:17 PM
 */
public class S322 {

    List<List<Integer>> ret;
    int min = Integer.MAX_VALUE;


    public int coinChange(int[] coins, int amount) {
        ret = new LinkedList<>();

        Integer[] integers = new Integer[coins.length];


        for (int i = 0; i < coins.length; i++) integers[i] = coins[i];

        Arrays.sort(integers, Collections.reverseOrder());

        dfs(integers, 0, amount, new LinkedList<>());
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(Integer[] candidates, int start, int target, LinkedList<Integer> path) {

        if (target < 0 || path.size() >= min) {
            return;
        }

        if (target == 0) {
            System.out.println(path);
            ret.add((List<Integer>) path.clone());
            min = Math.min(min, path.size());
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            path.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], path);
            path.removeLast();
        }

    }

}
