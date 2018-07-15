package com.wchb.leetcode;

import java.util.*;

/**
 * @date 6/14/18 5:56 PM
 */
public class S144 {


    /************************************************************/
    //迭代
    public List<Integer> preorderTraversalV3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (Objects.isNull(root)) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            list.add(curNode.val);

            if (curNode.right != null) stack.push(curNode.right);
            if (curNode.left != null) stack.push(curNode.left);
        }

        return list;
    }

    /************************************************************/
    //递归
    public List<Integer> preorderTraversalV2(TreeNode root) {
        return preorderTraversal(new LinkedList<>(), root);
    }

    private List<Integer> preorderTraversal(List<Integer> list, TreeNode node) {
        if (Objects.isNull(node)) {
            return list;
        }
        list.add(node.val);
        preorderTraversal(list, node.left);
        preorderTraversal(list, node.right);
        return list;
    }

    /************************************************************/
    //command
    public List<Integer> preorderTraversalV1(TreeNode root) {
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
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
                stack.push(new Command("print", command.node));
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
