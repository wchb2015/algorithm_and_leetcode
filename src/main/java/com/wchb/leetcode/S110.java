package com.wchb.leetcode;

import java.util.Objects;

/**
 * @date 6/8/18 1:05 PM
 */
public class S110 {

    //递归地检查根节点以及左右子树的高度满足AVL树的要求即可
    public boolean isBalanced(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        return Math.abs(getBalanceFactor(root)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getBalanceFactor(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


