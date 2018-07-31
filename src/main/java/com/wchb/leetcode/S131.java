package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/21/18 7:59 PM
 */
public class S131 {

    List<List<String>> ret = new LinkedList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() <= 0) return ret;
        dfs(s, 0, new LinkedList<>());
        return ret;
    }


    private void dfs(String s, int index, LinkedList<String> path) {

        if (index == s.length()) {
            ret.add((List<String>) path.clone());
            return;
        }

        for (int offset = 1; index + offset <= s.length(); offset++) {
            String temp = s.substring(index, index + offset);
            if (isPalindrome(temp)) {
                path.add(temp);
                dfs(s, index + offset, path);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;

        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) return false;
        }

        return true;
    }

}
