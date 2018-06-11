package com.wchb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 6/11/18 11:45 AM
 */
public class S260 {

    //如果A[i]不在set中，则插入,如果已经在，则在set中删除
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        int[] ans = new int[2];

        for (int i = 0; i < 2; i++) {
            ans[i] = (int) set.toArray()[i];

        }
        return ans;
    }
}
