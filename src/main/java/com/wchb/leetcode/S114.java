package com.wchb.leetcode;

/**
 * @date 9/21/18 9:06 AM
 */
public class S114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenAndReturnLast(root);
    }

    private TreeNode flattenAndReturnLast(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null && root.right != null) {
            //最核心的在这里(不要忘了下面这行)
            flattenAndReturnLast(root.right);
            return root;
        } else if (root.right == null && root.left != null) {
            TreeNode node = flattenAndReturnLast(root.left);
            root.right = node;
            root.left = null;
            return root;
        } else {
            TreeNode lR = flattenAndReturnLast(root.left);
            TreeNode rR = flattenAndReturnLast(root.right);
            TreeNode ll = lR;
            while (ll.right != null) {
                ll = ll.right;
            }

            ll.right = rR;

            root.right = lR;

            root.left = null;

            return root;
        }
    }
}
