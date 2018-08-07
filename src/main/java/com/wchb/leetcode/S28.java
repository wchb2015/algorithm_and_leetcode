package com.wchb.leetcode;

/**
 * @date 8/7/18 1:27 PM
 */
public class S28 {


    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;

        int i = 0;

        while (i < haystack.length() - needle.length() + 1) {

            if (haystack.charAt(i) == needle.charAt(0)) {
                int pa = i + 1;
                int pb = 1;
                while (pa < haystack.length() && pb < needle.length()) {
                    if (haystack.charAt(pa) != needle.charAt(pb)) break;
                    pa++;
                    pb++;
                }
                if (pb == needle.length()) return i;
            }
            i++;
        }
        return -1;
    }
}
