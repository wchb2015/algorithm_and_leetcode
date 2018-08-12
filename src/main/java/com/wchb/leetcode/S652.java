package com.wchb.leetcode;

import java.util.*;

/**
 * @date 8/11/18 10:57 AM
 */
public class S652 {
    Map<String, Integer> map;
    LinkedList<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        map = new HashMap<>();
        ans = new LinkedList<>();

        collect(root);

        return ans;
    }

    public String collect(TreeNode node) {
        if (node == null) return "#";
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);


        Integer prev = map.get(serial);
        if (prev == null) {
            map.put(serial, 1);
        } else {
            map.put(serial, prev + 1);
            if (prev == 1) ans.add(node);
        }

        return serial;
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
