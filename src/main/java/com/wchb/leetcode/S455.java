package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 6/22/18 8:15 PM
 */
public class S455 {

    //T: O(nlogn)+O(n) = O(nlogn)
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = g.length - 1;
        int j = s.length - 1;
        int ret = 0;

        //最大的饼干给最贪心的小朋友
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
