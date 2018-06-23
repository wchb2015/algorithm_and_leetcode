package com.wchb.leetcode;

/**
 * @date 6/23/18 7:04 AM
 */
public class S387 {

    public int firstUniqChar(String s) {

        if (s == null || s.trim().length() == 0) {
            return -1;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
