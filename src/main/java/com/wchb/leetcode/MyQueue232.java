package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 8/11/18 2:42 PM
 */
public class MyQueue232 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

//    入队时，将元素压入s1。
//    出队时，将s1的元素逐个“倒入”（弹出并压入）s2，将s2的顶元素弹出作为出队元素，之后再将s2剩下的元素逐个“倒回”s1。

    /**
     * Initialize your data structure here.
     */
    public MyQueue232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int ret = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return ret;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int ret = stack2.peek();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return ret;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
