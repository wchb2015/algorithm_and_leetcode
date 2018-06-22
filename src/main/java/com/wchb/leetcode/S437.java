package com.wchb.leetcode;

/**
 * @date 6/21/18 11:17 AM
 */
public class S437 {

    //在以root为根节点的二叉树中,寻找和为sum的路径,返回这样的路径的个数.
    public int pathSum(TreeNode root, int sum) {

        int ret = 0;

        if (root == null) {
            return ret;
        }

        ret += findPath(root, sum);//包含root
        ret += pathSum(root.left, sum);//不包含root
        ret += pathSum(root.right, sum);//不包含root

        return ret;
    }

    //在以node为根的二叉树中,寻找包含node的路径,和为sum,
    //返回这样的路径的个数
    private int findPath(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        int res = 0;

        if (sum == root.val) {
            res += 1;
        }
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
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
