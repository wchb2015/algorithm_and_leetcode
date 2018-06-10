package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 6/9/18 10:34 AM
 */
public class S88 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int[] numbers = combinedWith(nums1, m, nums2, n);
        if (m > 0 && numbers[m - 1] > numbers[m]) {
            merge2(numbers, 0, m, m + n - 1);
        }
        System.out.println(Arrays.toString(numbers));
    }


    //nums1 has enough space (size that is greater or equal to m + n)
    // to hold additional elements from nums2
    private int[] combinedWith(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0 && n == 0) {
            return nums1;
        }

        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

        return nums1;
    }

    private void merge2(int[] numbers, int l, int m, int r) {
        int[] aux = Arrays.copyOfRange(numbers, 0, r + 1);

        int i = l, j = m;

        for (int k = l; k <= r; k++) {
            if (i >= m) {
                numbers[k] = aux[j];
                j++;
            } else if (j > r) {
                numbers[k] = aux[i];
                i++;
            } else if (aux[j] > aux[i]) {
                numbers[k] = aux[i];
                i++;
            } else {//(aux[j] <= aux[i])
                numbers[k] = aux[j];
                j++;
            }
        }
    }

}
