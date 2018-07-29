package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 7/26/18 8:09 PM
 */
public class S678 {

    public boolean checkValidString(String s) {

        if (s == null || s.trim().length() == 0) return true;

        int min_op = 0, max_op = 0;

        for (int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);

            if (c == '(') min_op++;
            else min_op--;
            if (c != ')') max_op++;
            else max_op--;

            if (max_op < 0) return false;
            min_op = Math.max(0, min_op);

        }
        return min_op == 0;
    }

    /************************************************************/

    public boolean checkValidStringV2(String s) {

        if (s == null || s.trim().length() == 0) return true;

        Stack<Character> left = new Stack<>();
        Stack<Character> star = new Stack<>();

        int a=0, b = 0;

        //(*  true;
        //)*  false;
        //*)  true;
        //*(  false;


        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (c == '(') {
                a++;
                left.push(c);
            } else if (c == '*') {
                star.push(c);
            } else {
                b++;
                if (left.empty() && star.empty()) return false;
                if (!left.empty()) left.pop();
                else star.pop();
            }
        }

        while (!left.empty() && !star.empty()) {
            if (left.size() > star.size()) return false;
            left.pop();
            star.pop();
        }

        return left.isEmpty();

    }

}
