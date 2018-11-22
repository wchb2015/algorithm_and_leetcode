package com.wchb.leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 6/11/18 3:13 PM
 */
public class S102 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        createLevelLinkedList(root, ans, 0);
        return ans;
    }


    private void createLevelLinkedList(TreeNode root, List<List<Integer>> lists, int level) {
        if (root == null) return;//base case;
        List<Integer> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root.val);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
