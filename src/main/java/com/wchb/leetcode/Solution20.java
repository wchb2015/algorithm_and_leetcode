package com.wchb.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class Solution20 {

    private static final Logger logger = LoggerFactory.getLogger(Solution20.class);

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "({[]})";
        String s2 = "(){}[]";
        String s3 = "(){}[]{";

        logger.info(" s1 , {}", isValid(s1));
        logger.info(" s2 , {}", isValid(s2));
        logger.info(" s3 , {}", isValid(s3));

    }
}