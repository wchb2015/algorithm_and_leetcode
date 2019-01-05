package com.wchb.leetcode;

/**
 * @date 7/24/18 7:17 AM
 */
public class S343 {

    //递归+记忆化搜索自顶向下解决问题.
    /************************************************************/

    int[] cache;

    public int integerBreak(int n) {
        cache = new int[n + 1];
        cache[1] = 1;
        return breakInteger(n);
    }

    //将n进行分割为至少2部分,返回分割后的最大乘积.
    private int breakInteger(int n) {
        if (cache[n] != 0) return cache[n];
        if (n == 1) return 1;
        int ret = -1;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, Math.max(i * (n - i), i * breakInteger(n - i)));
        }
        cache[n] = ret;
        return ret;
    }

    //DP: 自低向上解决

    /************************************************************/

    // mem[i] 表示将数字i分割(至少两部分)后得到的最大乘积.
    int[] mem;

    public int integerBreakV2(int n) {

        //dp[i] means output when input = i, e.g. dp[4] = 4 (2*2),dp[8] = 18 (2*2*3)...
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // fill the entire dp array
        for (int i = 2; i <= n; i++) {
            //let's say i = 8, we are trying to fill dp[8]:
            // if 8 can only be broken into 2 parts,
            // the answer could be among 1 * 7, 2 * 6, 3 * 5, 4 * 4...
            // but these numbers can be further broken.
            // so we have to compare 1 with dp[1], 7 with dp[7], 2 with dp[2], 6 with dp[6]...etc
            for (int j = 1; j <= i / 2; j++) {
                // use Math.max(dp[i],....)  so dp[i] maintain the greatest value
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}
