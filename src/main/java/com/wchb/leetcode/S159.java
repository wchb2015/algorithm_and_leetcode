package com.wchb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 9/9/18 8:34 AM
 */
public class S159 {
    int n;
    Set<Character> set;

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        n = s.length();
        if (n <= 2) return n;

        set = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (ans >= n - i) break;
            ans = Math.max(ans, helper(i, s));
        }

        return ans;
    }


    private int helper(int idx, String s) {
        set.clear();
        int ret = 0;
        for (int i = idx; i < n; i++) {

            set.add(s.charAt(i));
            if (set.size() == 3) return ret;
            ret++;
        }

        return ret;
    }
}
