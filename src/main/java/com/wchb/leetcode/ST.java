package com.wchb.leetcode;

import java.util.*;


/**
 * @date 12/29/18 12:27 PM
 */
public class ST {
    int n;

    public int numDecodings(String s) {
        n = s.length();
        if (n == 0) return 0;

        return numDecodings(0, s);
    }

    private int numDecodings(int idx, String s) {
        if (idx == n) return 1;
        if (s.charAt(idx) == '0') return 0;
        int res = numDecodings(idx + 1, s);
        if (idx == n - 1) return res;

        if (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7')) {
            res += numDecodings(idx + 2, s);
        }

        return res;
    }
}
