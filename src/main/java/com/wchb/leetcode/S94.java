package com.wchb.leetcode;

import java.util.*;

/**
 * @date 6/14/18 6:06 PM
 */
public class S94 {


    /************************************************************/
    public List<Integer> inorderTraversalV4(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode rightMost;

        while (cur != null) {
            if (cur.left == null) {
                list.add(cur.val);
                cur = cur.right;
            } else {

            }
        }

        return list;
    }

//    while(cur)
//    {
//        if(cur->left)
//        {
//            rightmost = cur->left;
//
//            while(!rightmost->right&&rightmost->right！=cur)
//
//            {
//                rightmost=rightmost->right;
//            }
//
//            if(!rightmost->right)rightmost->right = cur;
//            else {cout<<cur->val<<" ";cur = cur->right;rightmost->right=NULL;}
//        }
//
//        else {cout<<cur->val<<" ";cur = cur->right;}
//    }

    /************************************************************/
    public List<Integer> inorderTraversalV3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }

        return list;
    }

    /************************************************************/

    public List<Integer> inorderTraversalV2(TreeNode root) {
        return inorderTraversal(new LinkedList<>(), root);
    }

    private List<Integer> inorderTraversal(List<Integer> list, TreeNode node) {
        if (Objects.isNull(node)) {
            return list;
        }
        inorderTraversal(list, node.left);
        list.add(node.val);
        inorderTraversal(list, node.right);
        return list;
    }

    /************************************************************/
    public List<Integer> inorderTraversalV1(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Stack<Command> stack = new Stack<Command>();
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
                stack.push(new Command("print", command.node));
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
