package com.wchb.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @date 8/1/18 3:17 PM
 */
public class S443 {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n < 3) return n;

        char prev = chars[0];
        int freq = 1;

        int readIdx = 1;
        int writeIdx = 0;
        // ["a","a","b","b","c","c","c"]
        while (readIdx < n) {
            char cur = chars[readIdx++];
            // case1 equal
            if (cur == prev) {
                freq++;
            } else {
                chars[writeIdx++] = prev;
                if (freq > 1) {
                    String f = String.valueOf(freq);
                    for (int i = 0; i < f.length(); i++) {
                        chars[writeIdx++] = f.charAt(i);
                    }
                }
                prev = cur;
                freq = 1;
            }
        }

        if (freq == 1) {
            chars[writeIdx++] = prev;
        } else {
            chars[writeIdx++] = prev;
            String f = String.valueOf(freq);
            for (int i = 0; i < f.length(); i++) {
                chars[writeIdx++] = f.charAt(i);
            }
        }

        System.out.println(writeIdx);
        System.out.println(Arrays.toString(chars));
        return writeIdx;
    }
}
