package com.wchb.leetcode;

import java.util.*;

/**
 * @date 6/14/18 5:54 PM
 */
public class S145 {
    public List<Integer> postorderTraversal(TreeNode root) {
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

    public List<Integer> postorderTraversalV2(TreeNode root) {

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
