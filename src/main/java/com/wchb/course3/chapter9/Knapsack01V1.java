package com.wchb.course3.chapter9;

import java.util.Arrays;

/**
 * @date 7/25/18 1:42 PM
 */


// 背包问题
// 思路: 记忆化搜索
// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
// 空间复杂度: O(n * C)
public class Knapsack01V1 {
    private int[][] memo;

    /**
     * @param w
     * @param v
     * @param C
     * @return
     */
    public int knapsack01(int[] w, int[] v, int C) {

        if (w == null || v == null || w.length != v.length) throw new IllegalArgumentException("Invalid w or v");

        if (C < 0) throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if (n == 0 || C == 0) return 0;

        memo = new int[n][C + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return bestValue(w, v, n - 1, C);
    }

    /**
     * @param w
     * @param v
     * @param index
     * @param c
     * @return
     */
    // 用 [0...index]的物品,填充容积为c的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int c) {

        if (c <= 0 || index < 0) return 0;

        if (memo[index][c] != -1) return memo[index][c];

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index]) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        }

        memo[index][c] = res;

        return res;
    }

}
