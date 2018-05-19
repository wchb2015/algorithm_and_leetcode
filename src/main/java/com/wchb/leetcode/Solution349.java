package com.wchb.leetcode;

import java.util.*;

public class Solution349 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }


}
