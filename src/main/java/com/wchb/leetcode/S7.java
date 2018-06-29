package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

/**
 * @date 6/5/18 12:00 PM
 */
public class S7 {


    @CreatedByMyself
    public int reverse(int x) {

        StringBuilder sb = new StringBuilder();
        boolean isNegative = x < 0;
        char[] arr = String.valueOf(x).toCharArray();

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] == '-') {
                continue;
            }

            if (arr[i] == '0' && sb.length() == 0) {
                continue;
            }

            sb.append(arr[i]);
        }

        try {
            return isNegative ? -Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }



}
