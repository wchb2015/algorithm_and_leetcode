package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 7/26/18 8:09 PM
 */
public class S678 {

    public boolean checkValidString(String s) {

        if (s == null || s.trim().length() == 0) return true;

        int i = 0;
        int numOfAsterisk = 0;
        Stack<Character> stack = new Stack<>();
        while (i < s.length()) {

            Character c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    if (numOfAsterisk == 0) return false;
                    numOfAsterisk--;
                } else {
                    stack.pop();
                }

            } else {
                numOfAsterisk++;
            }

            i++;
        }
        return numOfAsterisk >= stack.size();
    }

    /************************************************************/
    public boolean checkValidStringV2(String s) {

        if (s == null || s.trim().length() == 0) return true;

        int i = 0;

        int left = 0;
        int right = 0;

        while (i < s.length()) {
            Character c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            } else {
                if (right == left) {
                    continue;
                } else if (left > right) {
                    right++;
                } else if (left < right) {
                    left++;
                }
            }

            if (Math.abs(left - right) > 1) return false;
            i++;
        }

        return left == right;
    }

}
