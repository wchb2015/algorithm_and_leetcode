package com.wchb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 11/6/18 7:50 PM
 */
public class S340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int ans = 0;

        int l = 0;
        int r = 0;

        Set<Character> set = new HashSet<>();

        while (l < n && r < n) {
            set.add(s.charAt(r));
            if (set.size() > k) {
                set.remove(s.charAt(l++));
            } else {
                ans = Math.max(ans, r - l + 1);
                r++;
            }

        }


        return ans;
    }
}
