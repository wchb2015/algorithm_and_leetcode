package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 6/21/18 4:14 PM
 */
public class S77 {

    List<List<Integer>> ret;

    public List<List<Integer>> combine(int n, int k) {
        ret = new LinkedList<>();
        dfs(n, k, 1, new LinkedList<>());
        return ret;
    }

    private void dfs(int n, int k, int index, LinkedList<Integer> path) {
        if (k == path.size()) {
            ret.add((List<Integer>) path.clone());
            return;
        }

        for (int i = index; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1, path);
            path.removeLast();
        }
    }
}

