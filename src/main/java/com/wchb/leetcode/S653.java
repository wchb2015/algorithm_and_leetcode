package com.wchb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 8/15/18 7:09 PM
 */
public class S653 {

    //If the sum of two elements x+y = k,and we already know that x exists in the given tree,
    //we only need to check if an element y exists in the given tree,such that
    //y=k-x.

    // We keep a track of the elements which have been found so far during the tree
    // traversal , by putting them into a set.

    // For every current node with a value of p,we check if k-p already exists in the array.

    Set<Integer> data;

    public boolean findTarget(TreeNode root, int k) {

        data = new HashSet<>();
        inorder(data, root);

        for (Integer i : data) {
            if (data.contains(k - i) && k - i != i) return true;
        }

        return false;
    }

    private void inorder(Set<Integer> data, TreeNode root) {
        if (root == null) return;

        inorder(data, root.left);
        data.add(root.val);
        inorder(data, root.right);
    }

    /************************************************************/
    public boolean findTargetV2(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return find(root, k, set);
    }

    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
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
