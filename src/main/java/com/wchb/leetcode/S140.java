package com.wchb.leetcode;

import java.util.*;

/**
 * @date 10/26/18 6:40 PM
 */
public class S140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet<>(wordDict), 0);
    }

    HashMap<Integer, List<String>> map = new HashMap<>();

    private List<String> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String subString = s.substring(start, end);
            if (wordDict.contains(subString)) {
                List<String> list = word_Break(s, wordDict, end);
                for (String L : list) {
                    res.add(subString + (L.equals("") ? "" : " ") + L);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
