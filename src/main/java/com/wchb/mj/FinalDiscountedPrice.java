package com.wchb.mj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @date 11/1/18 8:35 AM
 */
public class FinalDiscountedPrice {
    public void finalDiscountedPrice(int[] prices) {
        int discount = 0;
        int sum = 0;
        List<Integer> nonDisInx = new ArrayList<>();

        int n = prices.length;


        for (int i = 0; i < n; i++) {
            int curPrice = prices[i];
            sum += curPrice;
            boolean find = false;
            for (int j = i + 1; j < n; j++) {
                if (!find && prices[j] <= curPrice) {
                    find = true;
                    discount += prices[j];
                }
            }
            if (!find) nonDisInx.add(i);
        }


        System.out.println("total Price: " + (sum - discount));
        System.out.println("nonDisInx: " + nonDisInx);

    }

    // 用一个queue记录当前还没找到折扣的数
    // 初始化就是第一个数
    // 于是可以知道这个队列里面的数必然不递减
    // 否则就已经有数找到折扣，就可以出队了
    // 然后每次遇到一个新的数，把比这个数大的数都出队，然后把这个数加入到队列。
    // 复杂度O(n). 思路是先给O(n^2)的方法，然后再优化。

    //第一题 可以用stack实现 从后往前扫 维持stack递增
    public void finalDiscountedPriceV2(int[] prices) {
        int discount = 0;
        int sum = 0;
        LinkedList<Integer> nonDisInx = new LinkedList<>();

        int n = prices.length;
        for (int p : prices) sum += p;

        Stack<Integer> stack = new Stack<>();
        stack.push(prices[n - 1]);
        nonDisInx.addFirst(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            int curPrice = prices[i];

            if (curPrice >= stack.peek()) {
                discount += stack.peek();
            } else {
                stack.push(curPrice);
                nonDisInx.addFirst(i);
            }

        }

        System.out.println("total Price: " + (sum - discount));
        System.out.println("nonDisInx: " + nonDisInx);

    }
}


