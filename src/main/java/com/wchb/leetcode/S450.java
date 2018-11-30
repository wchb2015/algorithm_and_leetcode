package com.wchb.leetcode;

/**
 * @date 11/29/18 11:16 AM
 */
public class S450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                //待删除节点左右均不为空
                //找到比待删除节点大的最小节点,即待删除节点右子树的最小节点
                //用这个节点替代待删除节点的位置
                TreeNode successor = findMin(root.right);
                root.right = removeMin(root.right);
                successor.left = root.left;
                successor.right = root.right;

                root.left = null;
                root.right = null;

                return successor;
            }
        }
    }

    private TreeNode findMin(TreeNode root) {
        if (root == null) return root;

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }


    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }
}
