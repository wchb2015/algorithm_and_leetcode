package com.wchb.leetcode;

/**
 * @date 7/29/18 3:16 PM
 */
public class S796 {
    public boolean rotateString(String A, String B) {

        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.length() != B.length()) return false;
        if (A.length() == B.length() && B.length() == 0) return true;

        int a = A.length();

        for (int i = 0; i < a; i++) {

            for (int times = 0, j = i; times < a; times++, j++) {
                if (A.charAt(j % a) != B.charAt(times)) break;

                if (times == a - 1) return true;
            }
        }

        return false;
    }


    /************************************************************/
    public boolean rotateStringV2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
