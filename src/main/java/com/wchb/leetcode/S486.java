package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 10/29/18 6:22 PM
 */
public class S486 {
    public boolean PredictTheWinner(int[] nums) {

        //dp[i][j]表示玩家1从i到j的能选到的最大值之和
        int n = nums.length;

        int[][] dp = new int[n][n];
        if (n < 3) return true;

        int sum = 0;
        for (int a : nums) sum += a;

        for (int i = 0; i < n - 1; i++) {
            //len = 1的情况
            dp[i][i] = nums[i];
            //len = 2的情况
            dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        }
        dp[n - 1][n - 1] = nums[n - 1];

        //从len = 3开始枚举
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(
                        nums[i] + Math.min(dp[i + 1][j - 1], dp[i + 2][j]),
                        nums[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
            }
        }

        //若玩家1选的值之和大于等于全部和的一半，则胜出（或平局），sum + 1是为了处理sum为基数的情况，如：[1,3,1]
        if (dp[0][n - 1] >= (sum + 1) / 2)
            return true;
        else return false;


    }
}
