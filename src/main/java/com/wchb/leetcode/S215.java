package com.wchb.leetcode;

/**
 * @date 6/16/18 8:22 PM
 */
public class S215 {

    // Quick Sort Partition.
    // Time Complexity:  O(n)
    // Space Complexity: O(1)
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    private int findKthLargest(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }

        int p = partition(nums, l, r);

        if (p == k) {
            return nums[p];
        } else if (k < p) {
            return findKthLargest(nums, l, p - 1, k);
        } else {
            //k>p
            return findKthLargest(nums, p + 1, r, k);
        }

    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] > arr[p] ; arr[p+1...r] < arr[p]
    private int partition(int[] nums, int l, int r) {
        int v = nums[l];
        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > v) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
