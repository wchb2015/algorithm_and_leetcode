package com.wchb.leetcode;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @date 7/9/18 9:54 PM
 */
public class S414 {


    public int thirdMaxV2(int[] nums) {
        return nMax(nums, 3);
    }

    private int nMax(int[] nums, int n) {

        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);

            if (set.size() > n) {
                set.remove(set.first());
            }
        }

        return set.size() >= n ? set.first() : set.last();
    }

    public int thirdMax(int[] nums) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int max = nums[0];

        for (int i : nums) {
            if (q.contains(i)) {
                continue;
            }
            if (q.size() < 3) {
                q.add(i);
            } else {
                if (i > q.peek()) {
                    q.remove();
                    q.add(i);
                }
            }

            max = Math.max(max, i);
        }

        if (q.size() < 3) {
            return max;
        } else {
            return q.peek();
        }

    }
}
