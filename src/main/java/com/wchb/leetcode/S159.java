package com.wchb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    /************************************************************/
    public int lengthOfLongestSubstringTwoDistinctV2(String s) {
        int n = s.length();
        if (n <= 2) return n;

        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int start = 0;
        int end = 0;

        for (; end < n; end++) {
            if (!map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), 1);
            } else {
                int temp = map.get(s.charAt(end));
                map.put(s.charAt(end), ++temp);
            }
            while (map.size() == 3) {
                int temp = map.get(s.charAt(start));
                map.put(s.charAt(start), --temp);
                if (map.get(s.charAt(start)) == 0) map.remove(s.charAt(start));
                start++;
            }

            if (end - start + 1 > ans) {
                ans = end - start + 1;
            }
        }


        return ans;
    }
}
