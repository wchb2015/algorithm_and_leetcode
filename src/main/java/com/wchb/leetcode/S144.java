package com.wchb.leetcode;

import java.util.*;

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


    //使用 stack 的 非递归实现
    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (Objects.isNull(root)) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            list.add(curNode.val);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }

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
