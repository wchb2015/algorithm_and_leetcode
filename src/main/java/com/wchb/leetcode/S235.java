package com.wchb.leetcode;

import java.util.Objects;

/**
 * @date 6/21/18 12:15 PM
 */
public class S235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (Objects.isNull(root) || Objects.isNull(p) || Objects.isNull(q)) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // p, q两个节点一定在树中
        // 思考? 怎么判断p,q在不在树中.
        return root;
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
