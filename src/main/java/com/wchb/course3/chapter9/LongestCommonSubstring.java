package com.wchb.course3.chapter9;

import java.util.Arrays;

/**
 * @date 1/5/19 9:04 AM
 */
public class LongestCommonSubstring {

    public String lcs(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        int[] pos = new int[2];
        int maxLen = 0;

        // 对memo的第0行和第0列进行初始化
        int[][] memo = new int[m + 1][n + 1];

        // 动态规划的过程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                    if (memo[i][j] > maxLen) {
                        maxLen = memo[i][j];
                        pos[0] = i;
                        pos[1] = j;
                    }
                } else {
                    memo[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < memo.length; i++) {
            System.out.println(Arrays.toString(memo[i]));
        }

        System.out.println(Arrays.toString(pos));

        StringBuilder sb = new StringBuilder();


        int row = pos[0];
        int col = pos[1];

        while (row >= 0 && col >= 0) {
            if (memo[row][col] == 0) break;
            sb.insert(0, s1.charAt(row - 1));
            row--;
            col--;
        }


        System.out.println(sb.toString());
        return "";
    }

    public static void main(String[] args) {

        String s1 = "zbcdf";
        String s2 = "abcdaf";
        System.out.println((new LongestCommonSubstring()).lcs(s1, s2));


    }
}
