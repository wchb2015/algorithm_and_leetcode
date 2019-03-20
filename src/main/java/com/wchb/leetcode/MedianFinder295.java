package com.wchb.leetcode;


import java.util.PriorityQueue;

/**
 * @date 8/23/18 2:56 PM
 */
public class MedianFinder295 {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /**
     * initialize your data structure here.
     */
    public MedianFinder295() {

        min = new PriorityQueue<>();
        max = new PriorityQueue<>((i1, i2) -> i2 - i1);
    }

    public void addNum(int num) {
        if (min.size() == max.size()) {
            min.add(num);
        } else {
            max.add(num);
        }

        reBalance();
    }

    private void reBalance() {
        if (max.size() == 0) return;

        int s = max.peek();
        int l = min.peek();

        if (s > l) {
            max.poll();
            min.poll();
            max.offer(l);
            min.offer(s);
        }

    }

    public double findMedian() {
        if (max.isEmpty()) return min.peek();
        if (min.size() == max.size()) {
            return (max.peek() + min.peek()) / 2.0;
        }
        return min.peek();
    }
}
