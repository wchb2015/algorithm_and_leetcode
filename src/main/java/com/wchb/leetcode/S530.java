package com.wchb.leetcode;

import java.util.*;

/**
 * @date 6/10/18 5:29 PM
 */
public class S530 {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int min = list.get(1) - list.get(0);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    //中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(TreeNode node, List<Integer> list) {
        if (Objects.isNull(node)) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
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


