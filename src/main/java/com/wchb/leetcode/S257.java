package com.wchb.leetcode;

import java.util.*;

/**
 * @date 6/20/18 11:36 PM
 */
public class S257 {

    //递归
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

    /************************************************************/
    //BFS
    public List<String> binaryTreePathsV2(TreeNode root) {

        List<String> list = new ArrayList<String>();
        Queue<TreeNode> qNode = new LinkedList<TreeNode>();
        Queue<String> qStr = new LinkedList<String>();

        if (root == null) return list;
        qNode.add(root);
        qStr.add("");
        while (!qNode.isEmpty()) {
            TreeNode curNode = qNode.remove();
            String curStr = qStr.remove();
            if (curNode.left == null && curNode.right == null) list.add(curStr + curNode.val);
            else {
                if (curNode.left != null) {
                    qNode.add(curNode.left);
                    qStr.add(curStr + curNode.val + "->");
                }
                if (curNode.right != null) {
                    qNode.add(curNode.right);
                    qStr.add(curStr + curNode.val + "->");
                }
            }
        }
        return list;
    }

    /************************************************************/
    //DFS
    public List<String> binaryTreePathsV3(TreeNode root) {
        List<String> list = new ArrayList<String>();
        Stack<TreeNode> sNode = new Stack<TreeNode>();
        Stack<String> sStr = new Stack<String>();

        if (root == null) return list;
        sNode.push(root);
        sStr.push("");
        while (!sNode.isEmpty()) {
            TreeNode curNode = sNode.pop();
            String curStr = sStr.pop();

            if (curNode.left == null && curNode.right == null) list.add(curStr + curNode.val);
            else {
                if (curNode.left != null) {
                    sNode.push(curNode.left);
                    sStr.push(curStr + curNode.val + "->");
                }
                if (curNode.right != null) {
                    sNode.push(curNode.right);
                    sStr.push(curStr + curNode.val + "->");
                }
            }
        }
        return list;
    }

    /************************************************************/

    List<LinkedList<Integer>> ans;

    public List<String> binaryTreePathsV4(TreeNode root) {
        ans = new LinkedList<>();
        if (root == null) return new LinkedList<>();
        dfs(root, new LinkedList<>());
        return convert(ans);
    }

    private void dfs(TreeNode root, LinkedList path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            ans.add(new LinkedList<>(path));
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.remove(path.size() - 1);
    }

    private List<String> convert(List<LinkedList<Integer>> ans) {
        List<String> ret = new LinkedList<>();

        for (LinkedList<Integer> list : ans) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i == list.size() - 1) continue;
                sb.append("->");
            }
            ret.add(sb.toString());
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
