package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 6/22/18 9:26 AM
 */
public class S70 {


    //自低向上 动态规划
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }


    /************************************************************/
    //递归 超时
    public int climbStairsV1(int n) {
        return calcWays(n);
    }

    private int calcWays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return calcWays(n - 1) + calcWays(n - 2);
    }

}

