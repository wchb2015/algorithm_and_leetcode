package com.wchb.leetcode;

/**
 * @date 7/14/18 10:57 AM
 */
public class S105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preorderIndex,
                           int inorderStart, int inorderEnd) {

        if (inorderStart > inorderEnd || preorderIndex > preorder.length - 1) return null;

        int rootVal = preorder[preorderIndex];
        int inOrderIndex = findIndex(inorder, rootVal);

        int leftSubTreeLength = inOrderIndex - inorderStart;


        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, inorder, preorderIndex + 1, inorderStart, inOrderIndex - 1);
        root.right = build(preorder, inorder, preorderIndex + 1 + leftSubTreeLength, inOrderIndex + 1, inorderEnd);
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
