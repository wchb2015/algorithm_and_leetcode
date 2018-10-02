package com.wchb.leetcode;

import java.util.TreeSet;

/**
 * @date 6/18/18 2:38 PM
 */

// TODO: 6/18/18  
public class S220 {

    // Using Tree Set
    // Time Complexity: O(nlogk)
    // Space Complexity: O(k)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //The ceiling(E e) method is used to return the least
        // element in this set greater than or equal to the given element,
        // or null if there is no such element.
        if (t < 0) return false;

        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (record.ceiling((long) nums[i] - (long) t) != null &&
                    record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t)
                return true;

            record.add((long) nums[i]);

            if (record.size() == k + 1)
                record.remove((long) nums[i - k]);
        }

        return false;

    }
}
