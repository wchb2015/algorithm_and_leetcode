package com.wchb.leetcode;

/**
 * @date 8/11/18 11:45 AM
 */
public class S606 {

    public String tree2str(TreeNode t) {

        return collect(t);
    }

    private String collect(TreeNode t) {
        if (t == null) return "";

        StringBuilder sb = new StringBuilder();

        sb.append(t.val);
        if (t.left != null) {
            sb.append("(").append(collect(t.left)).append(")");
        }
        if (t.right != null) {
            if (t.left == null) sb.append("()");
            sb.append("(").append(collect(t.right)).append(")");
        }
        return sb.toString();
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
