package com.wchb.leetcode;


import java.util.PriorityQueue;

/**
 * @date 8/23/18 2:56 PM
 */
public class MedianFinder295 {

    PriorityQueue<Integer> left;// smaller half
    PriorityQueue<Integer> right;// larger half

    /**
     * initialize your data structure here.
     */
    public MedianFinder295() {
        left = new PriorityQueue<>((i1, i2) -> i2 - i1);// Max Heap store the smaller half
        right = new PriorityQueue<>();// Max Heap store the larger half
    }

    public void addNum(int num) {
        if (right.size() > left.size()) {
            left.add(num);
        } else {
            right.add(num);
        }

        if (left.size() > 0) {
            int smaller = left.peek();
            int larger = right.peek();

            if (smaller > larger) {
                right.add(left.poll());
                left.add(right.poll());
            }
        }
    }

    public double findMedian() {
        if (right.size() == left.size())
            return (double) left.peek() + ((double) right.peek() - (double) left.peek()) / 2.0d;
        return right.size() > left.size() ? right.peek() : left.peek();
    }
}
