package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 12/15/18 7:55 PM
 */
public class S958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        boolean isLast = false;

        while (!q.isEmpty()) {

            int n = q.size();
            if (n != i) isLast = true;
            i = i * 2;

            while (n > 0) {
                n--;
                TreeNode cur = q.remove();

                if (!isLast) {
                    if (cur.left == null || cur.right == null) return false;
                    q.add(cur.left);
                    q.add(cur.right);
                } else {
                    if ((cur.left == null || cur.right == null) && n != 0) return false;

                }

            }
        }


        return true;
    }
}
