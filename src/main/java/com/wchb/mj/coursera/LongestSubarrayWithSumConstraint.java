package com.wchb.mj.coursera;


/**
 * @date 10/30/18 6:39 PM
 */
public class LongestSubarrayWithSumConstraint {

    /*
     *
     * 1. Traverse the array and check if on adding the current element its sum is less than or equal to k.
       2. If it’s less than k then add it to sum and increase the count.
       3. Else
        Remove the first element of sub  array and decrease the count.
        Again check if on adding the current element its sum is less than or equal to k.
        If it’s less than k then add it to sum and increase the count.

        4. Keep track of Maximum count.
     * */

    // function to find the length of largest
    // subarray having sum atmost k.
    public static int atMostSum(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
        int cnt = 0, maxcnt = 0;

        for (int i = 0; i < n; i++) {

            // If adding current element doesn't
            // cross limit add it to current window
            if ((sum + arr[i]) <= k) {
                sum += arr[i];
                cnt++;
            }

            // Else, remove first element of current
            // window.
            else if (sum != 0) {
                sum = sum - arr[i - cnt] + arr[i];
            }

            // keep track of max length.
            maxcnt = Math.max(cnt, maxcnt);
        }
        return maxcnt;
    }
}
