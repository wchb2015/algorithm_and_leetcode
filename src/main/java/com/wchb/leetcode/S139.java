package com.wchb.leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * @date 8/21/18 11:59 AM
 */
public class S139 {


    private HashMap<String, Boolean> mem = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        //In memory, directly return
        if (mem.containsKey(s)) return mem.get(s);
        // Whole String is a word, memorize and return
        if (wordDict.contains(s)) {
            mem.put(s, true);
            return true;
        }

        // Try every break point.
        for (int j = 1; j < s.length(); j++) {
            String left = s.substring(0, j);
            String right = s.substring(j, s.length());
            //Find the solution for s.

            if (wordDict.contains(left) && wordBreak(right, wordDict)) {
                mem.put(s, true);
                return true;
            }

        }

        //No solution for s, memorize and return
        mem.put(s, false);
        return false;
    }
}
