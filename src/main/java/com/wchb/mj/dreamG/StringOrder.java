package com.wchb.mj.dreamG;

import java.util.Arrays;

/**
 * @date 12/1/18 6:02 PM
 */
public class StringOrder {

    public boolean solution(String s, String order) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 'a'] = i;
        }

        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            int cur = arr[s.charAt(i) - 'a'];
            if (cur == -1) continue;
            if (prev > cur) return false;
            prev = cur;
        }

        return true;
    }
}
