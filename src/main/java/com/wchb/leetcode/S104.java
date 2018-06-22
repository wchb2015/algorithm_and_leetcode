package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

/**
 * @date 6/20/18 4:10 PM
 */
public class S104 {

    @CreatedByMyself
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;

        depth = maxDepth(root, depth);

        return depth;
    }

    private int maxDepth(TreeNode root, int depth) {
        if (root == null || (root.left == null && root.right == null)) {
            return depth;
        }
        depth = depth + 1;
        return Math.max(maxDepth(root.left, depth), maxDepth(root.right, depth));
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /************************************************************************************/

    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
