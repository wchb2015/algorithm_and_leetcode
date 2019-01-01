package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 12/31/18 10:27 AM
 */
public class S659 {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> appendfreq = new HashMap<>();

        for (int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);
        for (int i = 0; i < n; i++) {
            if (freq.get(nums[i]) == 0) {
                System.out.println("skip : " + i);
                continue;
            }

            if (appendfreq.getOrDefault(nums[i], 0) > 0) {
                System.out.println("append : " + i);

                appendfreq.put(nums[i], appendfreq.get(nums[i]) - 1);
                appendfreq.put(nums[i] + 1, appendfreq.getOrDefault(nums[i] + 1, 0) + 1);
            } else if (freq.getOrDefault(nums[i] + 1, 0) > 0 && freq.getOrDefault(nums[i] + 2, 0) > 0) {
                System.out.println("start : " + i);

                freq.put(nums[i] + 1, freq.get(nums[i] + 1) - 1);
                freq.put(nums[i] + 2, freq.get(nums[i] + 2) - 1);
                appendfreq.put(nums[i] + 3, appendfreq.getOrDefault(nums[i] + 3, 0) + 1);
            } else {
                return false;
            }
            freq.put(nums[i], freq.get(nums[i]) - 1);
        }

        return true;
    }
}
