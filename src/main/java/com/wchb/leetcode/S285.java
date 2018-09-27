package com.wchb.leetcode;

/**
 * @date 7/13/18 8:56 PM
 */
public class S285 {

    // find p first
    // case 1: Node has right subtree
    // Go deep to leftmost node in right subtree
    // Or Find min in right subtree

    //case 2: No right subtree
    // Go to the nearest ancestor for which given node would be in left subtree

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (p.right != null) {
            return findMin(p.right);
        } else {
            TreeNode ans = null;
            TreeNode ancestor = root;
            while (ancestor != p) {
                if (p.val < ancestor.val) {
                    ans = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return ans;
        }
    }

    private TreeNode findMin(TreeNode node) {
        if (node == null) return null;

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


}
