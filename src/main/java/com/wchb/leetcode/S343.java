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

        mem = new int[n + 1];
        mem[1] = 1;
        for (int i = 2; i <= n; i++) {
            //求解mem[j]
            for (int j = 1; j <= i - 1; j++) {
                //j+(i-j)
                //j*(i-j),j*mem[i-j]
                mem[i] = Math.max(mem[i], Math.max(j * (i - j), j * mem[i - j]));
            }
        }

        return mem[n];
    }
}
