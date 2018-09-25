package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 9/24/18 1:29 PM
 */
public class S116 {

    List<List<TreeLinkNode>> levels;

    public void connect(TreeLinkNode root) {
        if (root == null) return;

        levels = new LinkedList<>();
        LinkedList<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeLinkNode> level = new LinkedList<>();

            while (size > 0) {
                size--;
                TreeLinkNode cur = q.pop();

                level.add(cur);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            levels.add(level);
        }

        for (List<TreeLinkNode> level : levels) helper(level);
    }


    private void helper(List<TreeLinkNode> list) {
        if (list.size() < 2) return;

        for (int i = 0; i + 1 < list.size(); i++) {
            list.get(i).next = list.get(i + 1);
        }
    }


    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
