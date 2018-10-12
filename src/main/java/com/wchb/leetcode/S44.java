package com.wchb.leetcode;

/**
 * @date 10/11/18 7:22 PM
 */
public class S44 {


    public boolean comparison(String str, String pattern) {

        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()) {
            // advancing both pointers
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            } else if (p < pattern.length() && pattern.charAt(p) == '*') {
                /* * found, only advancing pattern pointer*/
                starIdx = p;
                match = s;
                p++;
            } else if (starIdx != -1) {
                // last pattern pointer was *, advancing string pointer
                p = starIdx + 1;
                match++;
                s = match;
            } else return false;
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }

}