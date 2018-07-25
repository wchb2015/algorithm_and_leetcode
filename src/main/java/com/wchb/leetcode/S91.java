package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/24/18 12:28 PM
 */
public class S91 {

    private List<List<String>> ret;

    public int numDecodings(String s) {
        ret = new LinkedList<>();
        dfs(s, 0, new LinkedList<>());
        return ret.size();
    }


    private void dfs(String s, int level, LinkedList<String> path) {

        if (level >= s.length()) {
            System.out.println(path);
            ret.add((List<String>) path.clone());
            return;
        }

        int first = Character.getNumericValue(s.charAt(level));
        int second = level + 2 <= s.length() ? Integer.parseInt(s.substring(level, level + 2)) : 0;
        path.add(s.charAt(level) + "");
        if (first >= 1 && first <= 9) dfs(s, level + 1, path);
        if (second >= 10 && second <= 26) dfs(s, level + 2, path);
        path.removeLast();

    }

    /************************************************************/
    //l=(l+1)+(l+2)
    //l+1 =(l+2)+(l+3)
    int[] memo;

    public int numDecodings2(String s) {
        memo = new int[s.length() + 1];
        return dfs2(s, 0);
    }

    private int dfs2(String s, int level) {

        if (level == s.length()) return 1;
        if (memo[level] != 0) return memo[level];
        int ways = 0;

        int first = Character.getNumericValue(s.charAt(level));
        int second = level + 2 <= s.length() ? Integer.parseInt(s.substring(level, level + 2)) : 0;

        if (first >= 1 && first <= 9) ways += dfs2(s, level + 1);
        if (second >= 10 && second <= 26) ways += dfs2(s, level + 2);

        memo[level] = ways;
        return ways;
    }

    /************************************************************/
    //DP
    int[] dp;

    public int numDecodings3(String s) {
        int n = s.length();
        dp = new int[n + 1];

        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;


        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));

            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }

            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
