package com.wchb.leetcode;

import java.util.PriorityQueue;

/**
 * @date 6/14/18 1:05 PM
 */
public class S283 {
    public void moveZeroes(int[] nums) {
        PriorityQueue queue = new PriorityQueue();
        for (int i = 0; i < nums.length; ++i) {
            System.out.println("start : " + queue);
            if (nums[i] == 0) {
                queue.add(i);
            } else if (!queue.isEmpty()) {
                int key = Integer.parseInt(queue.remove().toString());
                nums[key] = nums[i];
                nums[i] = 0;
                queue.add(i);
            }
            System.out.println("end : " + queue);
        }
    }
}
