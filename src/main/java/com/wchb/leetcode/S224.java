package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 8/10/18 2:16 PM
 */
public class S224 {
    //digit: it should be one digit from the current number
    //'+': number is over, we can add the previous number and start a new number
    //'-': same as above
    //'(': push the previous result and the sign into the stack, set result to 0,
    // just calculate the new result within the parenthesis.
    //')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis,
    // second is the temporary result before this pair of parenthesis.
    // We add them together.
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += num * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
