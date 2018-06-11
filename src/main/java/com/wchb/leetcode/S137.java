package com.wchb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @date 6/11/18 11:56 AM
 */
public class S137 {


    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, set.contains(n));
            set.add(n);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(Boolean.FALSE)) {
                return (int) entry.getKey();
            }
        }
        throw new RuntimeException("not found");
    }

}
