package com.wchb.leetcode;

// TODO: 6/1/18 为什么3个判断?  isBalanced.return

public class Solution110 {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (Math.abs(leftDepth - rightDepth) <= 1) &&
                isBalanced(root.left)
                && isBalanced(root.right);
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int bigger = Math.max(leftDepth, rightDepth);
        return bigger + 1;
    }


}

