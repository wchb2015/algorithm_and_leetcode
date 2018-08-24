package com.wchb.leetcode;

/**
 * @date 8/9/18 9:19 AM
 */
public class S4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // even (n/2+n/2-1) / 2;
        // odd  (2/n);
        int n = nums1.length + nums2.length;
        int[] arr = new int[n];

        merge(arr, nums1, nums2);

        if (n % 2 == 0) return ((arr[n / 2] + arr[n / 2 - 1]) / 2.0);
        return (double) arr[n / 2];

    }


    private void merge(int[] arr, int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            merge(arr, nums2, nums1);
            return;
        }

        int i = 0;
        int p1 = 0;
        int p2 = 0;

        while (i < arr.length) {

            if (p1 >= nums1.length) {
                arr[i++] = nums2[p2++];
            } else if (p2 >= nums2.length) {
                arr[i++] = nums1[p1++];
            } else if (nums1[p1] > nums2[p2]) {
                arr[i++] = nums2[p2++];
            } else {
                arr[i++] = nums1[p1++];
            }
        }

    }
}
