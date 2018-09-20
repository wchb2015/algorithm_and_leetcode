package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 8/11/18 12:09 PM
 */
public class S545 {

    List<Integer> ans = new ArrayList<>(1000);

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if (root == null) return ans;

        ans.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return ans;
    }

    public void leftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        ans.add(root.val);
        if (root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }

    public void rightBoundary(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return;
        if (root.right == null) rightBoundary(root.left);
        else rightBoundary(root.right);
        ans.add(root.val); // add after child visit(reverse)
    }

    public void leaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}
