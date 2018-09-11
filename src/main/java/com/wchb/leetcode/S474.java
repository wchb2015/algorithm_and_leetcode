package com.wchb.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 9/10/18 8:49 AM
 */
public class S474 {
    List<List<String>> subs;

    public int findMaxForm(String[] strs, int m, int n) {
        subs = new LinkedList<>();
        dfs(strs, 0, new LinkedList<>());

        Collections.sort(subs, (l1, l2) -> l2.size() - l1.size());

        System.out.println(subs);
        return 1;
    }


    private void dfs(String[] strs, int start, LinkedList<String> path) {
        if (start == strs.length) {
            subs.add(new LinkedList<>(path));
            return;
        }

        subs.add(new LinkedList<>(path));
        for (int i = start; i < strs.length; i++) {
            path.add(strs[i]);
            dfs(strs, i + 1, path);
            path.removeLast();
        }
    }

    /************************************************************/
    // recursion+memo
    int[][][] memo;

    public int findMaxFormV2(String[] strs, int m, int n) {
        memo = new int[strs.length][m + 1][n + 1];
        return calculate(strs, 0, m, n);
    }

    public int calculate(String[] strs, int i, int zeroes, int ones) {

        if (i == strs.length) return 0;
        if (memo[i][zeroes][ones] != 0) {
            System.out.println(" i: " + i + " 0: " + zeroes + " 1: " + ones);
            return memo[i][zeroes][ones];
        }

        int[] count = countZeroesOnes(strs[i]);
        int taken = 0;
        if (zeroes - count[0] >= 0 && ones - count[1] >= 0)
            taken = calculate(strs, i + 1, zeroes - count[0], ones - count[1]) + 1;
        int not_taken = calculate(strs, i + 1, zeroes, ones);
        int ret = Math.max(taken, not_taken);

        memo[i][zeroes][ones] = ret;

        return ret;
    }

    public int[] countZeroesOnes(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }
}
