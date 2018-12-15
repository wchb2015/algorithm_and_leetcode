package com.wchb.leetcode;

import java.util.*;

/**
 * @date 7/23/18 4:51 PM
 */
public class S120 {


    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] dp = new int[rows][rows];

        // base case
        List<Integer> lastRow = triangle.get(rows - 1);
        for (int i = 0; i < lastRow.size(); i++) {
            dp[rows - 1][i] = lastRow.get(i);
        }

        for (int i = rows - 2; i >= 0; i--) {
            List<Integer> cols = triangle.get(i);
            for (int j = 0; j < cols.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + cols.get(j);
            }
        }

        return dp[0][0];
    }

    /*******************************************************/

    public int minimumTotalV2(List<List<Integer>> triangle) {
        int n = triangle.size();

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int self = triangle.get(i).get(j);
                int res = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + self;
                triangle.get(i).set(j, res);
            }
        }

        return triangle.get(0).get(0);
    }


}
