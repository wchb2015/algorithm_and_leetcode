package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 7/16/18 7:14 PM
 */
public class MinStack155 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack155() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack1.push(x);

        if (!stack2.isEmpty() && stack2.peek() >= x) {
            stack2.push(x);
        }
    }

    public void pop() {
        int x = stack1.pop();
        if (x == stack2.peek()) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
