package com.wchb.leetcode;

import java.util.HashSet;
import java.util.List;

/**
 * @date 8/21/18 11:59 AM
 */
public class S139 {

    // 0 un compute
    // 1 true;
    // -1 false;
    int[] mem;

    public boolean wordBreak(String s, List<String> wordDict) {
        mem = new int[s.length()];
        return helper(s, new HashSet<>(wordDict), 0);
    }

    private boolean helper(String s, HashSet<String> strings, int i) {
        if (i == s.length()) return true;

        if (mem[i] != 0) return mem[i] == 1;

        for (int end = i + 1; end <= s.length(); end++) {
            if (strings.contains(s.substring(i, end)) && helper(s, strings, end)) {
                mem[i] = 1;
                return true;
            }
        }
        mem[i] = -1;
        return false;
    }
}
