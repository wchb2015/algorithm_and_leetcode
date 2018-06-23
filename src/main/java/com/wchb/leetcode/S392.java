package com.wchb.leetcode;

/**
 * @date 6/22/18 9:44 PM
 */
public class S392 {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            System.out.println(s.charAt(i) + " ==== " + t.charAt(j));
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }


        return i == s.length();
    }


}
