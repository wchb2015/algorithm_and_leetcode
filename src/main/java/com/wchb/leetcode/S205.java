package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 10/18/18 7:24 PM
 */
public class S205 {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();

        if (n <= 1) return true;

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }
}
