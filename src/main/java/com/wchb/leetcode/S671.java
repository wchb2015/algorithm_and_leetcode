package com.wchb.leetcode;

import java.util.PriorityQueue;

/**
 * @date 7/14/18 6:56 AM
 */
public class S671 {

    public int findSecondMinimumValue(TreeNode root) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        preOrder(root, q);
        if (q.size() >= 2) {
            q.remove();
            return q.remove();
        } else {
            return -1;
        }
    }

    private void preOrder(TreeNode root, PriorityQueue<Integer> q) {
        if (root == null) {
            return;
        }
        q.add(root.val);
        System.out.println(root.val + "----" + q);

        if (!q.contains(root.val)) {
            if (q.size() < 2) {
                q.add(root.val);
            } else if (q.size() == 2 && root.val < q.peek()) {
                q.remove();
                q.add(root.val);
            }
        }

        preOrder(root.left, q);
        preOrder(root.right, q);
    }
}
