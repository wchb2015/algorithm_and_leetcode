package com.wchb.leetcode;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @date 7/9/18 9:54 PM
 */
public class S414 {

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int k = 3;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (q.contains(i)) continue;
            max = Math.max(max, i);
            q.add(i);
            if (q.size() == k + 1) {
                q.remove();
            }
        }

        return q.size() == k ? q.peek() : max;
    }

    /************************************************************/

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

}
