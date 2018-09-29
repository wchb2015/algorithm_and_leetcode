package com.wchb.leetcode;


import java.util.PriorityQueue;

/**
 * @date 8/23/18 3:50 PM
 */
public class MedianFinder295V2 {

    /*  What a median is?
        A median is the value in a list of numbers for which half the numbers are below half the numbers are above.
        That is, if you were to put them in sorted order then it’d be the midpoint.
        If there’s two midpoints as in there’s an even number of values in the list,
         then the median is the average of those two values.

        That’ll work but it’s pretty slow. It’ll take n squared time.

        Let’s remember that a median is the number which half numbers are below half the numbers are above,
        so rather than keeping everything sorted which is  kind of unnecessary.
        Let’s actually just keep two buckets of numbers, 1 which is the lower half of numbers
        and one which is the upper half of numbers.
        Then when a number comes in look at its value and determine whether it’s in the lower half or the upper half.
        We want to keep these two buckets pretty balanced too so they shouldn't be ever different in size by more than one.
        So we want to be roughly half on each side.

        Then to get the median we just need to pull out the appropriate value.

        If the buckets are different sizes, then take the bigger bucket and pick either the min or max
        depending on whether it’s the lower half or the upper half.

        If the buckets are the same size then take the biggest element from the lower half and smallest element  from the upper half and average those.

        A heap is the perfect data structure for this problem because it allows us to very efficiently pull out the biggest element from a bucket or the smallest element from bucket.

        What we can do is we can keep a max heap of lower part of the numbers and a min heap of the upper part of the numbers.*/


    private PriorityQueue<Double> lowerNums;
    private PriorityQueue<Double> upperNums;

    /**
     * initialize your data structure here.
     */
    public MedianFinder295V2() {

        lowerNums = new PriorityQueue<>((d1, d2) -> d2.compareTo(d1));
        upperNums = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (lowerNums.size() == 0 || num < lowerNums.peek()) {
            lowerNums.add((double) num);
        } else {
            upperNums.add((double) num);
        }

        if (lowerNums.size() > upperNums.size()) {
            reBalance(upperNums, lowerNums);
        } else {
            reBalance(lowerNums, upperNums);
        }
    }

    public double findMedian() {
        if (upperNums.size() == lowerNums.size()) {
            return (upperNums.peek() + lowerNums.peek()) / 2.0d;
        } else {
            return upperNums.size() > lowerNums.size() ? upperNums.peek() : lowerNums.peek();
        }
    }

    private void reBalance(PriorityQueue<Double> small, PriorityQueue<Double> bigger) {
        if (bigger.size() - small.size() > 1) {
            small.add(bigger.remove());//lower's max or upper's min.
        }
        return;
    }

}
