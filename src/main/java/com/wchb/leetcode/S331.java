package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 7/14/18 2:37 PM
 */
public class S331 {

    public boolean isValidSerialization(String preorder) {

        if (preorder == null || preorder.trim().length() == 0) return false;
        if ("#".equals(preorder)) return true;
        if (preorder.startsWith("#")) return false;

        String[] arr = preorder.split(",");
        Stack<String> stack = new Stack<>();

        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {

            while (arr[i].equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }

            stack.push(arr[i]);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

}
