package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/13/18 8:56 PM
 */
public class S285 {


    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<Integer> list = new LinkedList<>();

        inOrder(root, list);

        Integer target = null;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > p.val) {
                target = list.get(i);
                break;
            }
        }

        return find(root, target);
    }

    private static TreeNode find(TreeNode root, Integer target) {
        if (target == null || root == null) {
            return null;
        }

        if (root.val == target) {
            return root;
        }

        if (root.val > target) {
            return find(root.left, target);
        } else {
            return find(root.right, target);
        }
    }

    private static void inOrder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);

        node.left = new TreeNode(1);

        S285.inorderSuccessor(node, new TreeNode(1));

    }

}
