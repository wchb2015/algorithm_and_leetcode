package com.wchb.leetcode;

/**
 * @date 10/11/18 7:22 PM
 */
public class S44 {


    /************************************************************/


    public boolean isMatch(String str, String pattern) {

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

    /************************************************************/


// boolean[][] t is a two-dimensional boolean array and t[i][j] is indicating that is the substring in the string
// from 0 till i and the substring in pattern 0 to j are they a match or not.
// t[i][j] will take one of these  three values here.

//    t[i][j]= t[i-1][j-1]  if(s[i]==p[j]||p[j]==‘?’)
//    t[i][j]= t[i-1][j]||t[i][j-1]  if p[j]==‘*’
//    t[i][j]= false
    public boolean isMatchV1(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();

        // empty pattern can only match with empty string
        if (m == 0) return (n == 0);

        // lookup table for storing results of sub problems
        boolean[][] lookup = new boolean[n + 1][m + 1];

        // initialize lookup table to false

        // empty pattern can match with empty string
        lookup[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1] ||
                            lookup[i - 1][j];

                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?' ||
                        str.charAt(i - 1) == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                    // If characters don't match
                else lookup[i][j] = false;
            }
        }

        return lookup[n][m];

    }
}