package com.wchb.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @date 8/23/18 2:56 PM
 */
public class MedianFinder295 {


    private ArrayList<Double> data;

    /**
     * initialize your data structure here.
     */
    public MedianFinder295() {
        data = new ArrayList<>();
    }

    public void addNum(int num) {
        data.add((double) num);
    }

    public double findMedian() {

        Collections.sort(data);

        int n = data.size();

        if (n % 2 == 0) {
            return (data.get(n / 2) + data.get(n / 2 - 1)) / 2;
        } else {
            return data.get(n / 2);
        }

    }
}
