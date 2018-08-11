package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 8/10/18 11:44 AM
 */
public class S572 {


    //check if  t has the same structure and node values with a subtree of s.
    public boolean isSubtree(TreeNode s, TreeNode t) {


        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
            if (isSame(node, t)) return true;
        }

        return false;
    }


    private boolean isSame(TreeNode s, TreeNode t) {

        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
