package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

/**
 * @date 6/20/18 4:37 PM
 */
public class S226 {


    public TreeNode invertTreeV2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }


    @CreatedByMyself
    //Wrong
    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null || root.right == null) {
            return root;
        }

        swap(invertTree(root.left), invertTree(root.right));
//        swap(invertTree(root.left), invertTree(root.right));
        return root;
    }


    private void swap(TreeNode nodeA, TreeNode nodeB) {
        int temp = nodeA.val;
        nodeA.val = nodeB.val;
        nodeB.val = temp;
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
