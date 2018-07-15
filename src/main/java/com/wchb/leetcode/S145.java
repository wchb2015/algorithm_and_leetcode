package com.wchb.leetcode;

import java.util.*;

/**
 * @date 6/14/18 5:54 PM
 */
public class S145 {

    /************************************************************/
    //迭代解法
    public List<Integer> postorderTraversalV3(TreeNode root) {

        LinkedList<Integer> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.addFirst(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        return ret;
    }


    /************************************************************/
    //递归解法
    public List<Integer> postorderTraversalV2(TreeNode root) {
        return postorderTraversal(new LinkedList<>(), root);
    }

    private List<Integer> postorderTraversal(List<Integer> list, TreeNode node) {
        if (Objects.isNull(node)) {
            return list;
        }
        postorderTraversal(list, node.left);
        postorderTraversal(list, node.right);
        list.add(node.val);
        return list;
    }

    /************************************************************/
    //Command解法
    public List<Integer> postorderTraversalV1(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }


        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.empty()) {
            Command command = stack.pop();

            if (command.s.equals("print")) {
                res.add(command.node.val);
            } else {
                assert command.s.equals("go");
                stack.push(new Command("print", command.node));
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }
        return res;
    }


    private class Command {
        String s;   // go, print
        TreeNode node;

        Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
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
