package com.wchb.leetcode;

/**
 * @date 8/1/18 3:17 PM
 */
public class S443 {
    public int compress(char[] chars) {

        int len = chars.length;
        if (len == 1) return len;

        int i = 0, j = 0, count;

        while (j < len) {

            char curChar = chars[j];
            count = 0;

            while (j + 1 < len && chars[j + 1] == curChar) {
                count++;
                j++;
            }

            chars[i++] = curChar;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[i++] = c;
                }
            }

            j++;

        }


        return i + 1;
    }
}
