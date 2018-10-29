package com.wchb.epi;

/**
 * @date 10/28/18 4:13 PM
 */
public class Epi171 {


    //tc : O(sn)
    //sc : O(sn)
    // LC 39


    // Definition:
    // dp[i][j]: the number of ways in which we can achieve a total of j points by using [0....i] numbers
    // Induction rule:
    // dp[i][j] = withoutThisNum + withThisNum;
    // withoutThisNum = dp[i-1][j]
    // withThisNum = dp[i][j-nums[i]]

    //Base case: dp[i][0]=1 One  way to reach 0.

    //Result: dp[n-1][finalScore]

    public int findNum(int[] nums, int finalScore) {
        int n = nums.length;

        int[][] dp = new int[n][finalScore + 1];
        for (int i = 0; i < n; i++) {

            dp[i][0] = 1; // One  way to reach 0.

            for (int j = 1; j <= finalScore; ++j) {
                int withoutThisNum = i - 1 >= 0 ? dp[i - 1][j] : 0;
                int withThisNum = j >= nums[i] ? dp[i][j - nums[i]] : 0;
                dp[i][j] = withoutThisNum + withThisNum;
            }
        }
        return dp[n - 1][finalScore];
    }


}
