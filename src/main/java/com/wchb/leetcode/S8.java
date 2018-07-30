package com.wchb.leetcode;

/**
 * @date 7/29/18 4:13 PM
 */
public class S8 {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) return 0;
        boolean isNegative = false;

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c == ' ') continue;
            if (c == '-' || c == '+') {
                isNegative = (c == '-');
                str = str.substring(++i);
                break;
            }
            str = str.substring(i);
            break;
        }

        int j = 0;

        // remaining characters must be digits.
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (isNumber(c)) {
                j++;
            } else {
                if (j == 0) return 0;
                break;
            }
        }

        long sum = 0;

        for (int k = 0; k < j; k++) {
            sum = sum * 10 + str.charAt(k) - '0';
            if (sum > Integer.MAX_VALUE) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        sum = isNegative ? -sum : sum;

        return (int) sum;
    }

    private boolean isNumber(Character character) {
        return character >= '0' && character <= '9';
    }
}
