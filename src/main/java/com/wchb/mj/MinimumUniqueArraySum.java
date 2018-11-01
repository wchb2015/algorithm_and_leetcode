package com.wchb.mj;

import java.util.Arrays;

/**
 * @date 10/31/18 12:45 PM
 */
// Coursera
//https://www.geeksforgeeks.org/making-elements-distinct-sorted-array-minimum-increments/
public class MinimumUniqueArraySum {

    // To find minimum sum
    // of unique elements.
    public int minSum(int[] arr) {

        Arrays.sort(arr);
        int n = arr.length;
        int sum = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {

                // While current element is same as
                // previous or has become smaller
                // than previous.
                int j = i;
                while (j < n && arr[j] <= arr[j - 1]) {
                    arr[j]++;
                    j++;
                }
            }
            sum += arr[i];
        }

        return sum;
    }
}
