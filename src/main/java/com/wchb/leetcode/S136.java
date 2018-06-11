package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @date 6/4/18 10:43 AM
 */
public class S136 {

    //自己写的算法
    @CreatedByMyself
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int ret = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : nums) {
            if (map.containsKey(i)) {
                map.put(i, 2);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return (int) entry.getKey();
            }
        }
        return ret;
    }

    // TODO: 6/4/18
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public int singleNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }

        return (int) set.toArray()[0];
    }
}
