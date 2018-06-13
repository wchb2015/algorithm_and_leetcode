package com.wchb.leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 6/11/18 3:13 PM
 */
public class S102 {


    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        List<List<Integer>> ret = new LinkedList<>();

        if (root == null) {
            return ret;
        }

        q.add(new Pair<>(root, 0));
        while (!q.isEmpty()) {

            Pair<TreeNode, Integer> pair = q.remove();

            TreeNode node = pair.getKey();
            int level = pair.getValue();

            if (level == ret.size()) {
                ret.add(new LinkedList<>());
            }

            ret.get(level).add(node.val);

            if (node.left != null) {
                q.add(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                q.add(new Pair<>(node.right, level + 1));
            }
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

//    // 二分搜索树的层序遍历
//    public void levelOrder() {
//        // 我们使用LinkedList来作为我们的队列
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while (!q.isEmpty()) {
//            Node node = q.remove();
//            System.out.println(node.key);
//            if (node.left != null) {
//                q.add(node.left);
//            }
//            if (node.right != null) {
//                q.add(node.right);
//            }
//        }
//    }