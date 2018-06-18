package com.wchb.leetcode;

import java.util.PriorityQueue;

/**
 * @date 6/16/18 8:22 PM
 */
public class S215 {

    // Quick Sort Partition.
    // Time Complexity:  O(n)
    // Space Complexity: O(1)
    public int findKthLargest(int[] nums, int k) {

        if (k < 1 || nums == null || nums.length < k) {
            throw new IllegalArgumentException();
        }

        int left = 0;
        int right = nums.length - 1;
        k = k - 1;

        if (left == right) {
            return nums[left];
        }

        int p = partition(nums, left, right);

        while (p != k) {
            if (p > k) {
                p = partition(nums, left, p - 1);
            } else {
                p = partition(nums, p + 1, right);
            }
        }

        return nums[p];
    }

    // return index wall
    // [left....wall] >=  pivot; [wall+1...i-1] < pivot
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int wall = left;

        //[left....wall] >= v ; [wall+1...i-1] < v
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > pivot) {
                wall++;
                swap(nums, i, wall);
            }
        }
        swap(nums, left, wall);
        return wall;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargestV2(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.remove();
            }
        }

        return priorityQueue.remove();
    }


}
