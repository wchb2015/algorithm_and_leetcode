package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @date 6/14/18 5:56 PM
 */
public class S144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal(new LinkedList<>(), root);
    }

    private List<Integer> preorderTraversal(List<Integer> list, TreeNode node) {
        if (Objects.isNull(node)) {
            return list;
        }
        list.add(node.val);
        preorderTraversal(list, node.left);
        preorderTraversal(list, node.right);
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
