package com.wchb.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 7/23/18 4:51 PM
 */
public class S120 {


//    cache[i][j]表明从最底层到i,j所用的最短距离是多少
//    cache[i][j]就等于cache[i+1][j](左下角)与cache[i+1][j+1](右下角)中最小的加上triangle[i][j]的值

    Map<String, Integer> map = new HashMap<>();

    //递归+记忆化搜索
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimum(0, 0, triangle);
    }

    private int minimum(int x, int y, List<List<Integer>> triangle) {
        if (map.containsKey(x + "," + y)) return map.get(x + "," + y);
        if (x >= triangle.size()) return 0;
        List<Integer> row = triangle.get(x);
        if (y >= row.size()) return 0;

        if (x == triangle.size() - 1) return triangle.get(x).get(y);

        int ret = Math.min(minimum(x + 1, y, triangle), minimum(x + 1, y + 1, triangle)) + row.get(y);
        map.put(x + "," + y, ret);
        return ret;
    }

    /************************************************************/

    public int minimumTotalV2(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] dp = new int[rows][rows];
        for (int i = rows - 1; i >= 0; i--) {
            List<Integer> cols = triangle.get(i);
            if (i == rows - 1) {
                for (int j = 0; j < cols.size(); j++) {
                    dp[rows - 1][j] = cols.get(j);
                }
            } else {
                for (int j = 0; j < cols.size(); j++) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + cols.get(j);
                }
            }
        }

        return dp[0][0];
    }

    /************************************************************/
    public int minimumTotalV3(List<List<Integer>> triangle) {

        int rows = triangle.size();
        int[] sum = new int[rows];

        List<Integer> lastRow = triangle.get(rows - 1);

        for (int i = 0; i < lastRow.size(); i++) sum[i] = lastRow.get(i);

        for (int i = rows - 2; i >= 0; i--) {
            List<Integer> curRow = triangle.get(i);
            for (int j = 0; j < curRow.size(); j++) {
                sum[j] = curRow.get(j) + Math.min(sum[j], sum[j + 1]);
            }
        }

        return sum[0];
    }

}
