package com.wchb.test;

/**
 * @date 7/21/18 12:42 PM
 */

public class BinaryTree {

    public BinaryTree leftChild;
    public BinaryTree rightChild;
    public boolean isGoalNode = false;
    public String name;

    BinaryTree(String name, BinaryTree left, BinaryTree right, boolean isGoalNode) {
        this.name = name;
        leftChild = left;
        rightChild = right;
        this.isGoalNode = isGoalNode;
    }
}
