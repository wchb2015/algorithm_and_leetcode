package com.wchb.course3.chapter9;

/**
 * @date 6/22/18 12:09 PM
 */

// 记忆化搜索
public class Fibonacci {

    private int num = 0;

    public int fib(int n) {

        num++;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public int getNum() {
        return num;
    }

    public static void main(String[] args) {

        int n = 20;

        Fibonacci solution = new Fibonacci();
        long startTime = System.currentTimeMillis();
        int res = solution.fib(n);
        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time : " + (endTime - startTime) + " ms");
        System.out.println("run function fib() " + solution.getNum() + " times.");
    }
}
