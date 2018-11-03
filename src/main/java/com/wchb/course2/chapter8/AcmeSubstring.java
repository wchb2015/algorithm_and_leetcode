package com.wchb.course2.chapter8;

/**
 * @date 11/1/18 11:48 AM
 */
public class AcmeSubstring {
    public int firstOccurrence(String a, String x) {
        int[] lps = longestPrefixSuffix(x);

        int i = 0, j = 0;
        while (i < a.length()) {

            if (j == x.length()) {
                return i - x.length();
            }
            if (a.charAt(i) == x.charAt(j) || x.charAt(j) == '*') {
                i++;
                j++;
            } else {
                if (j == 0)
                    i++;
                else
                    j = lps[j - 1];
            }
        }
        return j == x.length() ? i - x.length() : -1;
    }

    public int[] longestPrefixSuffix(String s) {
        int len = 0;
        int i = 1;
        int[] lps = new int[s.length()];
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = len;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return lps;
    }

}
