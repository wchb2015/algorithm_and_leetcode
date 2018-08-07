package com.wchb.leetcode;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @date 8/7/18 1:45 PM
 */
public class S187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new LinkedList<>();
        if (s == null || s.length() < 11) return ret;

        Set<String> set = new HashSet<>();


        int i = 0;
        while (i + 10 <= s.length()) {

            String temp = s.substring(i, i + 10);
            if (!set.add(temp) && !ret.contains(temp)) ret.add(temp);

            i++;
        }

        return ret;
    }
}
