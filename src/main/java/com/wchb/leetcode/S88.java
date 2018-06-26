package com.wchb.leetcode;

/**
 * @date 6/9/18 10:34 AM
 */
public class S88 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        for (int i = m + n - 1; i >= n; i--) {
            nums1[i] = nums1[i - n];
        }

        int i = n;  // pointer for nums1 [n, n+m)
        int j = 0;  // pointer for nums2 [0, n)
        int k = 0;  // pointer merged nums1 [0, n+m)

        while (k < m + n) {

            if (i >= m + n) {
                nums1[k++] = nums2[j++];
            } else if (j >= n) {
                nums1[k++] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                nums1[k++] = nums1[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
    }


}
