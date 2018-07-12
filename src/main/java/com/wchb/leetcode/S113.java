package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/11/18 3:32 PM
 */
public class S113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }

        if (root.left == null && root.right == null && root.val == sum) {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(root.val);
            ret.add(temp);
            return ret;
        }

        for (List<Integer> list : pathSum(root.left, sum - root.val)) {
            list.add(list.size(), root.val);
            ret.add(list);
        }

        for (List<Integer> list : pathSum(root.right, sum - root.val)) {
            list.add(list.size(), root.val);
            ret.add(list);
        }

        return ret;
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
