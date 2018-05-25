package com.wchb.course1.chapter6;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private Node root;
    private Integer size;


    public BST() {
        root = null;
        size = 0;
    }

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (Objects.isNull(node)) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }


    //递归
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (Objects.isNull(node)) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        } else if (node.e.compareTo(e) > 0) {
            return contains(node.right, e);
        } else if (node.e.compareTo(e) < 0) {
            return contains(node.left, e);
        }
        return false;
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 非递归 前序遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();

        if (Objects.isNull(root)) {
            return;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (Objects.nonNull(cur.right)) {
                stack.push(cur.right);
            }
            if (Objects.nonNull(cur.left)) {
                stack.push(cur.left);
            }
        }

    }


    //中序遍历
    public void inOrder() {
        inOrder(root);
    }


    //后续遍历
    public void postOrder() {
        postOrder(root);
    }

    //层序遍历
    public void levelOrder() {
        if (Objects.isNull(root)) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node front = q.poll();
            System.out.println(front.e);

            if (Objects.nonNull(front.left)) {
                q.add(front.left);
            }
            if (Objects.nonNull(front.right)) {
                q.add(front.right);
            }
        }

    }

    //寻找最小元素
    public E minimum() {
        if (size == 0) {
            throw new RuntimeException("bst is empty");
        }
        return minimum(root).e;

    }

    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (Objects.isNull(node.left)) {
            return node;
        }
        return minimum(node.left);
    }

    //寻找最小元素
    public E maximum() {
        if (size == 0) {
            throw new RuntimeException("bst is empty");
        }
        return maximum(root).e;
    }

    //返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node) {
        if (Objects.isNull(node.right)) {
            return node;
        }

        return maximum(node.right);
    }


    //从二分搜索树中删除最小值所在的节点,返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的跟
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //从二分搜索树中删除最大值所在的节点,返回最大值
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最大节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }


    //从二分搜索树中删除元素为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }

    //删除以node为根的二分搜索树中值为e的节点,递归算法
    //返回删除节点后新的二分搜索树的跟
    private Node remove(Node node, E e) {
        if (Objects.isNull(node)) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        if (e.compareTo(node.e) == 0) {
            if (node.left == null) {
                //待删除节点左子树为空
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                //待删除节点右子树为空
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待删除节点左右均不为空
            //找到比待删除节点大的最小节点,即待删除节点右子树的最小节点
            //用这个节点替代待删除节点的位置
          /* Wrong  Node newRoot = removeMin(node.right);
            newRoot.left = node.left;
            return newRoot;*/

            Node successor = minimum(node.right);

            successor.right = removeMin(node.right);
            size++;

            successor.left = node.left;


            node.left = node.right = null;
            size--;
            return successor;
        }
        return null;
    }

    private void inOrder(Node node) {
        if (Objects.isNull(node)) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    private void preOrder(Node node) {

        if (Objects.isNull(node)) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(Node node) {

        if (Objects.isNull(node)) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //向以node为根的二分搜索树中插入元素E,递归算法;
    private void addV1(Node node, E e) {
        //递归函数两部分 1. 递归终止的条件 2. 递归调用
        if (e.equals(node.e)) {
            return;
        }
        if (e.compareTo(node.e) < 0 && Objects.isNull(node.left)) {
            node.left = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) > 0 && Objects.isNull(node.right)) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }

    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);

        return sb.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (Objects.isNull(node)) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }

        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}