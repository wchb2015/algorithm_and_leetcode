package com.wchb.leetcode;


import java.util.ArrayList;

/**
 * @date 7/14/18 12:21 PM
 */
public class Codec297 {

    ArrayList<Integer> data = new ArrayList<>();
    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        helper(root);
        String str = data.toString();
        return str.substring(1, str.length() - 1);
    }

    private void helper(TreeNode root) {
        if (root == null) {
            data.add(-1);
            return;
        }
        data.add(root.val);
        helper(root.left);
        helper(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        return helper(dataArr);
    }

    private TreeNode helper(String[] arr) {
        if (idx == arr.length || arr[idx].trim().equals("-1")) {
            idx += 1;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[idx].trim()));
        root.left = helper(arr);
        root.right = helper(arr);

        return root;
    }

}
