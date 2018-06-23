package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 6/22/18 8:15 PM
 */
public class S455 {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = g.length - 1;
        int j = s.length - 1;
        int ret = 0;

        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                ret++;
                i--;
                j--;
            } else {
                i--;
            }
        }

        return ret;
    }
}
