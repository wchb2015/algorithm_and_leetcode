package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

/**
 * @date 6/5/18 12:00 PM
 */
public class S7 {


    @CreatedByMyself
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;

        char[] chars = String.valueOf(x).toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            if (i == 0 && chars[i] == '-') {
                isNegative = true;
                continue;
            }
            if (sb.length() == 0 && chars[i] == '0') {
                continue;
            }
            sb.append(chars[i]);
        }
        if (sb.length() == 0) {
            return 0;
        }
        try {
            return isNegative ? -Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
        } catch (NumberFormatException n) {
            return 0;
        }
    }

}
