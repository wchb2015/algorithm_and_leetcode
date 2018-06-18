package com.wchb.leetcode;

import com.wchb.course2.chapter8.Edge;

/**
 * @date 6/17/18 11:26 PM
 */
public class S65 {

    public boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        s = s.trim();
        if (s.endsWith("f") || s.endsWith("F") || s.endsWith("d") || s.endsWith("D")) {
            return false;
        }
        try {
            Double.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
