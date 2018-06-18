package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 6/17/18 7:51 PM
 */
public class S454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int target = 0 - A[i] - B[j];
                if (map.containsKey(target)) {
                    ret += map.get(target);
                }
            }

        }
        return ret;
    }
}