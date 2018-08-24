package com.wchb.leetcode;


import java.util.PriorityQueue;

/**
 * @date 8/23/18 3:50 PM
 */
public class MedianFinder295V2 {

    /**
     * 思路: 寻找data stream或者array中的中位数
     * 可以用两个heap来实现 一个max heap 一个min heap
     * 每次加一个数先放到max heap 然后把max heap中poll一个数出来放到min heap.
     * 同时要检查下max heap中的元素比min heap中要多;取中位数的时候.
     * 如果两个heap的size相同,则各poll一个元素出来算平均,否则max heap中poll出的就是median.
     * 复杂度. addNum: O(logN), space: O(n): findMedian: O(1)
     */

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder295V2() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.remove());

        if (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.remove());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return ((double) minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }
}
