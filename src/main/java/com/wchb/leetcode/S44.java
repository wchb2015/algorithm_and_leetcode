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

    /************************************************************/

/*

T is a two-dimensional boolean array and t[i][j] is indicating that is the substring in the string from 0 till i
 and the substring in pattern 0 to j are they a match or not.

    t[i][j] will take one of these  three values here.

    t[i][j]=t[i-1][j-1] if(s[i]==p[j]||p[j]==‘?’)
    t[i-1][j]||t[i][j-1] if p[j]==‘*’
    false*/
    public boolean isMatch(String s, String p) {

        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                match[s.length()][j] = true;
                if (j == p.length() - 1) match[s.length()][p.length()] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    match[i][j] = match[i - 1][j - 1];
                else if (p.charAt(j) == '*')
                    match[i][j] = match[i - 1][j] || match[i][j - 1];
                else
                    match[i][j] = false;
            }
        }
        return match[s.length()][p.length()];

    }

    public boolean isMatchV2(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[s.length()][p.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) != '*')
                break;
            else
                match[s.length()][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    match[i][j] = match[i + 1][j + 1];
                else if (p.charAt(j) == '*')
                    match[i][j] = match[i + 1][j] || match[i][j + 1];
                else
                    match[i][j] = false;
            }
        }
        return match[0][0];
    }


}