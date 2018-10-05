package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 10/4/18 10:03 AM
 */
public class S438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];
        List<Integer> ans = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length()) return ans;
        for (char c : p.toCharArray()) chars[c - 'a']++;

        int start = 0, end = 0, count = p.length();
        // Go over the string
        while (end < s.length()) {
            System.out.println(Arrays.toString(chars));
            // If the char at start appeared in p, we increase count
            if (end - start == p.length() && chars[s.charAt(start++) - 'a']++ >= 0)
                count++;
            // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
            if (--chars[s.charAt(end++) - 'a'] >= 0)
                count--;
            if (count == 0)
                ans.add(start);
        }

        return ans;
    }
}
