package com.wchb.leetcode;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @date 7/14/18 12:21 PM
 */
public class Codec297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        LinkedList<Integer> list = new LinkedList<>();
        inOrder(root, list);
        preOrder(root, list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(0)).append("#");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.length() == 0) {
            return null;
        }

        String[] strArr = data.split("#");

        int[] inOrder = new int[strArr.length / 2];
        int[] preOrder = new int[strArr.length / 2];

        for (int i = 0; i < strArr.length; i++) {
            if (i <= strArr.length / 2) {
                inOrder[i] = Integer.parseInt(strArr[i]);
            } else {
                preOrder[i - strArr.length / 2] = Integer.parseInt(strArr[i]);
            }
        }

        System.out.println(Arrays.toString(inOrder));
        System.out.println(Arrays.toString(preOrder));
        return null;
    }


    private void inOrder(TreeNode root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) inOrder(root.left, list);
        list.add(root.val);
        if (root.right != null) inOrder(root.right, list);
    }

    private void preOrder(TreeNode root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) preOrder(root.left, list);
        if (root.right != null) preOrder(root.right, list);
    }


}
