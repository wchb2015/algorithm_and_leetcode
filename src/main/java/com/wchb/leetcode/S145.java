package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @date 6/14/18 5:54 PM
 */
public class S145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversal(new LinkedList<>(), root);
    }

    private List<Integer> postorderTraversal(List<Integer> list, TreeNode node) {
        if (Objects.isNull(node)) {
            return list;
        }
        postorderTraversal(list, node.left);
        postorderTraversal(list, node.right);
        list.add(node.val);
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
