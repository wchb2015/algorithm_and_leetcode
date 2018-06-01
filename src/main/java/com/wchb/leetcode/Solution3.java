package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @date 5/31/18 11:42 PM
 */
public class Solution3 {


    public int lengthOfLongestSubstring(String s) {
        int ret = 0;

        if (s != null && s.length() > 0) {

            if (s.length() == 1) {
                return 1;
            }

            char[] chars = s.toCharArray();
            List<String> list = new ArrayList<>();
            for (int c = 0; c < chars.length; c++) {
                for (int i = 1; i <= chars.length - c; i++) {
                    list.add(s.substring(c, c + i));
                }
            }

            for (String str : list) {
                if (isUnique(str)) {
                    ret = str.length() > ret ? str.length() : ret;
                }
            }
        }
        return ret;
    }


    public boolean isUnique(String str) {
        if (str.length() == 0) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        if (set.size() == str.length()) {
            return true;
        }
        return false;
    }
}
