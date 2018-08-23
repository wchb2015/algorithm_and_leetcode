package com.wchb.leetcode;

/**
 * @date 8/22/18 2:38 PM
 */
public class S117 {

    //http://rainykat.blogspot.com/2017/02/leetcodef-117-populating-next-right.html

    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode pre = dummy;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            // done with the search of current level
            if (root == null) {
                root = dummy.next;
                pre = dummy;
                dummy.next = null;
            }
        }
    }


    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
