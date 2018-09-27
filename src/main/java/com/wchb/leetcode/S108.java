package com.wchb.leetcode;

/**
 * @date 9/26/18 10:07 AM
 */
public class S108 {

    // Time : o(N)
    // Key: Root node is middle element of sorted array
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {

        if (l > r) return null;

        int mid = (r + l) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, l, mid - 1);
        root.right = build(nums, mid + 1, r);
        return root;
    }
}
