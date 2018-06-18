package com.wchb.leetcode;

/**
 * @date 6/17/18 3:22 PM
 */
public class S125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }

        int length = s.length();
        int l = 0, r = length - 1;

        while (l < r) {
            if (!isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                if (!isEqual(s.charAt(l), s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    private boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isEqual(char a, char b) {
        return a == b || (Math.abs((int) a - (int) b) == 32 && isLetter(a) && isLetter(b));
    }
}
