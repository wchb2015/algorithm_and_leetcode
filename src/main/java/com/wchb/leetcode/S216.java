package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/22/18 7:58 PM
 */
public class S216 {
    List<List<Integer>> ret;

    //k 个数相加=n.
    public List<List<Integer>> combinationSum3(int k, int n) {
        ret = new LinkedList<>();

        if (n <= 0 || k <= 0) return ret;
        generateCombinations(k, n, 1, new LinkedList<>());
        return ret;
    }

    private void generateCombinations(int k, int n, int start, LinkedList<Integer> path) {

        if (0 == k) {
            if (0 == n) {
                ret.add((List<Integer>) path.clone());
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > n) return;
            path.add(i);
            generateCombinations(k - 1, n - i, i + 1, path);
            path.removeLast();
        }

    }

}
