package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 8/23/18 11:51 AM
 */
public class S227 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (' ' == s.charAt(i)) continue;
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }

            if (sign == '-') {
                stack.push(-num);
            } else if (sign == '+') {
                stack.push(num);
            } else if (sign == '*') {
                stack.push(stack.pop() * num);
            } else if (sign == '/') {
                stack.push(stack.pop() / num);
            }
            sign = s.charAt(i);
            num = 0;
        }

        int ans = 0;
        for (int i : stack) ans += i;
        return ans;
    }


}
