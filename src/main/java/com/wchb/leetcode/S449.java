package com.wchb.leetcode;

/**
 * @date 2/5/19 5:19 PM
 */
public class S449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        if (sb.length() == 0) {
            sb.append(root.val);
        } else {
            sb.append(",").append(root.val);
        }
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if (s.length() == 0) return null;
        String[] arr = s.split(",");
        int[] data = new int[arr.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(arr[i]);
        }

        return build(data, 0, data.length - 1);
    }

    private TreeNode build(int[] data, int start, int end) {
        if (start > end || start == -1) {
            return null;
        }
        TreeNode root = new TreeNode(data[start]);
        int nextIdx = find(data, start, end, data[start]);
        if (nextIdx == -1) {
            root.left = build(data, start + 1, end);
            return root;
        }
        root.left = build(data, start + 1, nextIdx - 1);
        root.right = build(data, nextIdx, end);
        return root;
    }

    private int find(int[] data, int startIdx, int end, int num) {
        for (int i = startIdx + 1; i <= end; i++) {
            if (data[i] > num) {
                return i;
            }
        }
        return -1;
    }
}
