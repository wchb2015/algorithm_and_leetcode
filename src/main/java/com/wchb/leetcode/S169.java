package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 8/9/18 12:00 PM
 */
public class S169 {

    public int majorityElement(int[] nums) {
        int mostFreq = 0;
        int ret = nums[0];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
                continue;
            }

            int pre = map.get(i);
            map.put(i, pre + 1);

            if (pre + 1 > mostFreq) {
                mostFreq = pre + 1;
                ret = i;
            }

        }

        return ret;
    }
}
