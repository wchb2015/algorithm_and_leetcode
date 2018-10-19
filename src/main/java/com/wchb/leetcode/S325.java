package com.wchb.leetcode;

import java.util.HashMap;

/**
 * @date 10/18/18 6:34 PM
 */
public class S325 {

    public int maxSubArrayLen(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int preSum = 0;
            for (int j = i; j < nums.length; j++) {
                preSum += nums[j];
                if (preSum == k) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    /************************************************************/

    // The HashMap stores the sum of all elements before index i as key,
    // and i as value. For each i, check not only the current sum but also
    // (currentSum - previousSum) to see if there is any that equals k, and update max length.
    public int maxSubArrayLenV2(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}
