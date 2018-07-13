package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 7/12/18 7:09 PM
 */
public class S186 {
    public void reverseWords(char[] str) {

        reverse(str, 0, str.length - 1);
        int start = 0;
        int end = 0;

        System.out.println(Arrays.toString(str));
        while (end < str.length) {
            while (end < str.length && str[end] != ' ') {
                end++;
            }
            reverse(str, start, end - 1);
            start = end + 1;
            end = start;
        }
    }

    public void reverse(char[] str, int start, int end) {
        if (start > end) {
            return;
        }
        for (; start < end; start++, end--) {
            char c = str[start];
            str[start] = str[end];
            str[end] = c;
        }
    }
}
