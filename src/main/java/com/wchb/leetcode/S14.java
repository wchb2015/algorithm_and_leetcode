package com.wchb.leetcode;

/**
 * @date 6/4/18 12:12 PM
 */
public class S14 {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        for (int i = 0; ; i++) {
            if (allTheSame(i, strs)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }


    private boolean allTheSame(int index, String[] strs) {

        if (index >= strs[0].length()) return false;
        char c = strs[0].charAt(index);

        for (int i = 1; i < strs.length; i++) {
            if (index >= strs[i].length() || strs[i].charAt(index) != c) return false;
        }

        return true;
    }

}
