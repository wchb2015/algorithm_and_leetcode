package com.wchb.leetcode;

import java.util.HashMap;

/**
 * @date 9/9/18 1:31 PM
 */
public class S337 {
    public int rob(TreeNode root) {
        return helper(root, new HashMap<>());
    }

    private int helper(TreeNode root, HashMap<TreeNode, Integer> dp) {
        if (root == null) return 0;
        if (dp.containsKey(root)) return dp.get(root);

        int withRoot = root.val;
        int withoutRoot = 0;

        if (root.left != null) {
            withRoot += helper(root.left.left, dp);
            withRoot += helper(root.left.right, dp);
        }

        if (root.right != null) {
            withRoot += helper(root.right.left, dp);
            withRoot += helper(root.right.right, dp);
        }

        withoutRoot = helper(root.left, dp) + helper(root.right, dp);


        int ans = Math.max(withRoot, withoutRoot);
        dp.put(root, ans);
        return ans;
    }

}
