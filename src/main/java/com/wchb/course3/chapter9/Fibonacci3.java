package com.wchb.course3.chapter9;

import java.util.Arrays;

/**
 * @date 6/22/18 12:19 PM
 */
// 动态规划
public class Fibonacci3 {

    public int fib(int n) {

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    public static void main(String[] args) {

        //int n = 42;
        int n = 42; // 注意: 我们使用n = 1000只是为了测试性能, 实际上会溢出
        // 斐波那契额数列是以指数速度上涨的

        Fibonacci3 solution = new Fibonacci3();
        long startTime = System.currentTimeMillis();
        int res = solution.fib(n);
        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time : " + (endTime - startTime) + " ms");
    }
}
