package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @date 6/14/18 6:06 PM
 */
public class S94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(new LinkedList<>(), root);
    }

    private List<Integer> inorderTraversal(List<Integer> list, TreeNode node) {
        if (Objects.isNull(node)) {
            return list;
        }
        inorderTraversal(list, node.left);
        list.add(node.val);
        inorderTraversal(list, node.right);
        return list;
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
