package com.wchb.test;

/**
 * @date 7/21/18 12:43 PM
 */
public class TreeSearch {
    public static BinaryTree makeTree() {
        BinaryTree root, a, b, c, d, e, f;
        c = new BinaryTree("C", null, null, false);
        d = new BinaryTree("D", null, null, false);
        e = new BinaryTree("E", null, null, true);
        f = new BinaryTree("F", null, null, false);
        a = new BinaryTree("A", c, d, false);
        b = new BinaryTree("B", e, f, false);
        root = new BinaryTree("Root", a, b, false);
        return root;
    }


    public static void main(String args[]) {
        BinaryTree tree = makeTree();
        System.out.println(solvable(tree));
    }


    static boolean solvable(BinaryTree node) {
        if (node.isGoalNode) return true;
        if (node.leftChild != null && solvable(node.leftChild)) return true;
        if (node.rightChild != null && solvable(node.rightChild)) return true;
        return false;
    }


}
