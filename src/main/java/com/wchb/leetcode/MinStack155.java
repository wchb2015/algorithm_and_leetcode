package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @date 7/16/18 7:14 PM
 */
public class MinStack155 {
    LinkedList<Integer> list;
    PriorityQueue<Integer> priorityQueue;

    /**
     * initialize your data structure here.
     */
    public MinStack155() {
        list = new LinkedList<>();
        priorityQueue = new PriorityQueue<>();
    }

    public void push(int x) {
        list.addFirst(x);
        priorityQueue.add(x);
    }

    public void pop() {
        int i = list.removeFirst();
        priorityQueue.remove(i);
    }

    public int top() {
        return list.getFirst();
    }

    public int getMin() {
        return priorityQueue.peek();
    }
}
