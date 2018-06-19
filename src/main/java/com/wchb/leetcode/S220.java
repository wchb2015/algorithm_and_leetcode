package com.wchb.leetcode;

import java.util.TreeSet;

/**
 * @date 6/18/18 2:38 PM
 */

// TODO: 6/18/18  
public class S220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 题目给的参数,一般都是先校验再使用
        if (nums.length < 2 || k <= 0 || t <= 0) {
            return false;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {


        }

        return false;
    }
}
