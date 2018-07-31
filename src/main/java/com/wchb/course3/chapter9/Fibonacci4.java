package com.wchb.course3.chapter9;

/**
 * @date 7/30/18 7:37 AM
 */


// Space to o(1)
public class Fibonacci4 {
    public int fib(int n) {

        if (n < 2) return n;
        int n1 = 1, n2 = 1;

        for (int i = 2; i < n; i++) {
            int n0 = n1 + n2;
            n2 = n1;
            n1 = n0;
        }
        
        return n1;
    }

    public static void main(String[] args) {

        //int n = 42;
        int n = 4; // 注意: 我们使用n = 1000只是为了测试性能, 实际上会溢出
        // 斐波那契额数列是以指数速度上涨的
        // f42=267914296

        Fibonacci4 solution = new Fibonacci4();
        long startTime = System.currentTimeMillis();
        int res = solution.fib(n);
        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time : " + (endTime - startTime) + " ms");
    }
}
