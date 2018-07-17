package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @date 7/16/18 11:26 PM
 */
public class MaxStack {

    LinkedList<Integer> list;
    PriorityQueue<Integer> priorityQueue;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        list = new LinkedList<>();
        priorityQueue = new PriorityQueue<>((x, y) -> y - x);
    }

    public void push(int x) {
        list.addFirst(x);
        priorityQueue.add(x);
    }

    public int pop() {
        int i = list.removeFirst();
        priorityQueue.remove(i);
        return i;
    }

    public int top() {
        return list.peek();
    }

    public int peekMax() {
        return priorityQueue.peek();
    }

    public int popMax() {
        int i = priorityQueue.remove();
        list.remove(Integer.valueOf(i));
        return i;
    }

}
