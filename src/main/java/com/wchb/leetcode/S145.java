package com.wchb.leetcode;

import java.util.*;

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

    public List<Integer> postorderTraversalV2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (Objects.isNull(root)) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }

            list.add(curNode.val);
        }

        return list;
    }

}
