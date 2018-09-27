package com.wchb.leetcode;

/**
 * @date 9/26/18 3:23 PM
 */
public class S270 {
    public int closestValue(TreeNode root, double target) {
        return helper(root, target, root.val);
    }


    private int helper(TreeNode root, double target, int closest) {
        if (root == null) return closest;

        if (Math.abs((double) root.val - target) < Math.abs((double) closest - target)) {
            closest = root.val;
        }

        if (root.val > target) return helper(root.left, target, closest);
        else return helper(root.right, target, closest);

    }
}
