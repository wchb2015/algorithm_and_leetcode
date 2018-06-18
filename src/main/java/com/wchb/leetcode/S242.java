package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 6/10/18 8:11 PM
 */
public class S242 {

    public boolean isAnagram(String s, String t) {

        if (s == t) {
            return true;
        }

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                int temp = map.get(c) - 1;
                if (temp == 0) {
                    map.remove(c);
                } else {
                    map.put(c, temp);
                }
            }
        }

        return map.isEmpty();
    }
}
