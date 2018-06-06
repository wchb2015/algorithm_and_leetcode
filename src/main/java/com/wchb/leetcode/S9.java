package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

/**
 * @date 6/5/18 9:52 AM
 */
public class S9 {


    @CreatedByMyself
    public boolean isPalindrome(int x) {


        boolean ret = true;

        String s = String.valueOf(x);

        char[] charArray = s.toCharArray();

        int length = charArray.length;

        for (int i = 0; i < length / 2; i++) {

            if (charArray[i] != charArray[length - 1 - i]) {
                return false;
            }
        }


        return ret;
    }


}
