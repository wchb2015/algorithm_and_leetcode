package com.wchb.leetcode;

/**
 * @date 7/14/18 11:53 AM
 */
public class S106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int[] inorder, int postorderIndex,
                           int inorderStart, int inorderEnd) {

        if (inorderStart > inorderEnd || postorderIndex < 0) return null;

        int rootVal = postorder[postorderIndex];
        int inOrderIndex = findIndex(inorder, rootVal);

        int rightSubTreeLength = inorderEnd - inOrderIndex;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(postorder, inorder, postorderIndex - 1 - rightSubTreeLength, inorderStart, inOrderIndex - 1);
        root.right = build(postorder, inorder, postorderIndex - 1, inOrderIndex + 1, inorderEnd);
        return root;
    }

    private int findIndex(int[] inorder, int rootVal) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }
}
