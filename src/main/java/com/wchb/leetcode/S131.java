package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/21/18 7:59 PM
 */
public class S131 {

    List<List<String>> ret;

    public List<List<String>> partition(String s) {

        ret = new LinkedList<>();
        if (s == null || s.trim().length() == 0) return ret;

        dfs(s, 0, 1, new LinkedList<>());
        return ret;
    }

    private void dfs(String s, int index, int offset, LinkedList<String> ans) {

        if (index == s.length()) {
            ret.add((List<String>) ans.clone());
            return;
        }

        for (; index + offset <= s.length(); offset++) {
            if (isPalindrome(s.substring(index, index + offset))) {
                ans.addLast(s.substring(index, index + offset));
                dfs(s, index + offset, 1, ans);
                ans.removeLast();
            } else {
                continue;
            }
        }

    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;

        int r = 0, l = s.length() - 1;

        while (r < l) {
            if (s.charAt(r) != s.charAt(l)) {
                return false;
            }
            r++;
            l--;
        }


        return true;
    }

}
