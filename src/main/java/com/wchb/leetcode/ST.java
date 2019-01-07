package com.wchb.leetcode;

import java.util.*;


/**
 * @date 12/29/18 12:27 PM
 */
public class ST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, TreeNode> map;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] v) {
        if (root == null) return new LinkedList<>();
        map = new HashMap<>();
        List<Integer> inOrder = new LinkedList<>();
        inOrder(root, inOrder);

        return helper(root, v, 0);
    }

    private List<Integer> helper(TreeNode root, int[] v, int idx) {
        if (idx == v.length || root == null) {
            return new LinkedList<>();
        }
        List<Integer> inOrder = new LinkedList<>();

        inOrder(root, inOrder);
        for (int i = idx, j = 0; i < v.length; i++, j++) {
            if (v[i] == inOrder.get(j)) continue;

            map.put(v[i], invertTree(map.get(v[i])));
            List<Integer> next = helper(map.get(v[i]), v, i);
            if (next.size() > 0 && next.get(0) == -1) return next;
            next.add(v[i]);
            return next;
        }

        return new LinkedList<>();

    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }


    private void inOrder(TreeNode root, List<Integer> inOrder) {
        if (root == null) return;
        inOrder.add(root.val);
        map.put(root.val, root);
        inOrder(root.left, inOrder);
        inOrder(root.right, inOrder);
    }

}
