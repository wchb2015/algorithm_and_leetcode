package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 6/20/18 11:36 PM
 */
public class S257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        if (root.left == null && root.right == null) {
            ret.add(String.valueOf(root.val));
            return ret;
        }
        List<String> strLeft = binaryTreePaths(root.left);
        for (int i = 0; i < strLeft.size(); i++) {
            ret.add(root.val + "->" + strLeft.get(i));
        }
        List<String> strRight = binaryTreePaths(root.right);
        for (int i = 0; i < strRight.size(); i++) {
            ret.add(root.val + "->" + strRight.get(i));
        }
        return ret;
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
