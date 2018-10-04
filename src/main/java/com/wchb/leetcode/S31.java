package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 8/2/18 3:15 PM
 */

public class S31 {
    /**
     * start scanning from the right;
     * Find a digit d1 which is not in ascending order from right
     * If all the digits right to left are ascending then reverse the entire array and return;
     * Find a digit d2 which is right of d1,such that it is the smallest number greater than d1
     * swap(d1,d2)
     * reverse the digits right of d1;
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        int n = nums.length;
        if (n <= 1) return;

        int d1 = n - 2;
        while (d1 - 1 >= 0 && nums[d1 - 1] > nums[d1]) {
            d1--;
        }
        if (d1 == 0) {
            reverse(nums, 0, n - 1);
            System.out.println(Arrays.toString(nums));
            return;
        }

        int d2 = n - 1;
        int temp = d1 + 1;

        while (temp < n) {
            if (nums[temp] < nums[d1]) break;
            d2 = temp;
            temp++;
        }


        swap(nums, d1, d2);
        reverse(nums, d1 + 1, n);
        System.out.println(Arrays.toString(nums));
        return;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    private void reverse(int[] nums, int start, int end) {
        if (start == end) return;

        for (int i = start; i <= (start + end) / 2; i++) {
            swap(nums, i, end - i);
        }

    }
}
