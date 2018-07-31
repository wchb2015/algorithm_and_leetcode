package com.wchb.leetcode;

/**
 * @date 7/30/18 6:16 PM
 */
public class S132 {
    int ret = Integer.MAX_VALUE;

    public int minCut(String s) {

        if (s == null || s.length() <= 1) return 0;

        dfs(s, 0, 0);

        return ret;
    }

    private void dfs(String s, int index, int ans) {

        if (ans - 1 >= ret) return;

        if (index == s.length()) {
            ret = Math.min(ans - 1, ret);
        }

        for (int offset = 1; index + offset <= s.length(); offset++) {
            String temp = s.substring(index, index + offset);
            if (isPalindrome(temp)) {
                dfs(s, index + offset, ans + 1);
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
