package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 7/16/18 2:19 PM
 */
public class S560 {


    // bt

    // for each sub array(i,j) check if the sum of sub array (i,j)==k

    // tc: o(n^3);

    // problems: repeat computation
    public int subarraySum(int[] nums, int k) {

        if (nums == null || nums.length == 0) return 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int idx = i; idx <= j; idx++) {
                    sum += nums[idx];
                }
                if (sum == k) count++;
            }
        }
        return count;
    }

    /************************************************************/

    // tc: o(n^2);
    public int subarraySumV1(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int preFixSum = 0;
            for (int j = i; j < nums.length; j++) {
                preFixSum += nums[j];

                if (preFixSum == k) count++;
            }
        }
        return count;
    }

    /************************************************************/

    // tc: o(n);
    // sc: o(n);
    public int subarraySumV2(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0, ans = 0;

        for (int ele : nums) {
            sum += ele;
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
