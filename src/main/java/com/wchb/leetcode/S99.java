package com.wchb.leetcode;

/**
 * @date 9/28/18 9:08 AM
 */
public class S99 {

    // 1. Visit all nodes of a tree in in-order fashion.
    // Keep track of previously visited node.
    // 2. At each node that is being visited, if value of node that is being visited> current node
    // 3. After all nodes are visited,swap p1 with p2.

    TreeNode p1 = null;
    TreeNode p2 = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        inOrder(root);

        int temp = p1.val;
        p1.val = p2.val;
        p2.val = temp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        if (pre != null && pre.val >= root.val) {
            if (p1 == null) p1 = pre;
            p2 = root;
        }
        pre = root;
        inOrder(root.right);
    }
}
