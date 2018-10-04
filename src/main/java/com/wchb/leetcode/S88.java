package com.wchb.leetcode;

/**
 * @date 6/9/18 10:34 AM
 */
public class S88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < m + n; i++) {
            if (p1 >= m) {
                nums1[i] = nums2[p2];
                p2++;
            } else if (p2 >= n) {
                nums1[i] = nums1[p1];
                p1++;
            } else if (nums1[p1] < nums2[p2]) {
                nums1[i] = nums1[p1];
                p1++;
            } else {
                nums1[i] = nums2[p2];
                p2++;
            }
        }
    }


}
