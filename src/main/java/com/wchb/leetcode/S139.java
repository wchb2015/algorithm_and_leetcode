package com.wchb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @date 8/21/18 11:59 AM
 */
public class S139 {

    Map<String, Boolean> cache;

    public boolean wordBreak(String s, List<String> wordDict) {
        cache = new HashMap<>();
        return helper(s, wordDict);
    }


    public boolean helper(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 0) return true;
        if (cache.containsKey(s)) return cache.get(s);

        for (int i = 0; i < n; i++) {

            String left = s.substring(0, i);
            String right = s.substring(i, n);
            if (helper(left, wordDict) && wordDict.contains(right)) {
                cache.put(s, true);
                return true;
            }

        }

        cache.put(s, false);
        return false;

    }

    /************************************************************/

    // 0 un compute
    // 1 true;
    // -1 false;
    int[] mem;

    public boolean wordBreakV2(String s, List<String> wordDict) {
        mem = new int[s.length()];
        return helperV2(s, new HashSet<>(wordDict), 0);
    }

    private boolean helperV2(String s, HashSet<String> strings, int i) {
        if (i == s.length()) return true;

        if (mem[i] != 0) return mem[i] == 1;

        for (int end = i + 1; end <= s.length(); end++) {
            if (strings.contains(s.substring(i, end)) && helperV2(s, strings, end)) {
                mem[i] = 1;
                return true;
            }
        }
        mem[i] = -1;
        return false;
    }

}
