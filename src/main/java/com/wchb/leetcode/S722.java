package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/27/18 9:17 PM
 */
public class S722 {

    private boolean notClose = false;

    public List<String> removeComments(String[] source) {

        List<String> ret = new LinkedList<>();


        for (int i = 0; i < source.length; i++) {
            if (isComment(source[i]) || notClose) {
                continue;
            }

            if (notClose) {

            }

            ret.add(source[i]);
        }

        return ret;

    }

    private boolean isComment(String s) {

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (c == ' ') continue;

            if (c == '/' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
                return true;
            }

            if (c == '/' && i + 1 < s.length() && s.charAt(i + 1) == '*') {
                notClose = true;
                return true;
            }
        }

        return false;
    }
}
