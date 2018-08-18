package com.wchb.leetcode;

/**
 * @date 8/17/18 11:39 AM
 */
public class S687 {

    private int ans;

    public int longestUnivaluePath(TreeNode root) {

        if (root == null) return 0;
        ans = 0;
        univaluePath(root);
        return ans;
    }

    private int univaluePath(TreeNode root) {

        if (root == null) return 0;
        int l = univaluePath(root.left);
        int r = univaluePath(root.right);

        int pl = 0;
        int pr = 0;
        if (root.left != null && root.val == root.left.val) pl = l + 1;
        if (root.right != null && root.val == root.right.val) pr = r + 1;

        ans = Math.max(ans, pl + pr);
        return Math.max(pl, pr);
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
