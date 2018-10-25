package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 10/24/18 4:54 PM
 */
public class S20 {
    public boolean isValid(String s) {

        int n = s.length();
        if (n == 0) return true;
        if (n % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '{' || arr[i] == '[' || arr[i] == '(') {
                stack.push(arr[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if ((arr[i] == '}' && topChar == '{') || (arr[i] == ')' && topChar == '(') || (arr[i] == ']' && topChar == '[')) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
