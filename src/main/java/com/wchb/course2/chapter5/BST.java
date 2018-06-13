package com.wchb.course2.chapter5;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @date 6/10/18 8:39 PM
 */

// 二分搜索树
// 由于Key需要能够进行比较, 所以需要extends Comparable<Key>
public class BST<Key extends Comparable<Key>, Value> {

    // 树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;  // 根节点
    private int count;  // 树种的节点个数

    // 构造函数, 默认构造一棵空二分搜索树
    public BST() {
        root = null;
        count = 0;
    }

    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    // 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
    // 返回插入新节点后的二分搜索树的根
    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            // key > node->key
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    // 查看二分搜索树中是否存在键key
    public boolean contain(Key key) {
        return contain(root, key);
    }

    private boolean contain(Node node, Key key) {
        if (Objects.isNull(node)) {
            return false;
        }

        if (node.key.compareTo(key) == 0) {
            return true;
        } else if (node.key.compareTo(key) > 0) {
            return contain(node.left, key);
        } else {
            //root.key.compareTo(key) < 0
            return contain(node.right, key);
        }

    }

    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public Value search(Key key) {
        return search(root, key);
    }

    // 在以node为根的二分搜索树中查找key所对应的value,递归算法
    // 若value不存在, 则返回NULL
    private Value search(Node node, Key key) {

        if (Objects.isNull(node)) {
            return null;
        }

        if (node.key.compareTo(key) == 0) {
            return node.value;
        } else if (node.key.compareTo(key) > 0) {
            return search(node.left, key);
        } else {
            //root.key.compareTo(key) < 0
            return search(node.right, key);
        }
    }

    // 二分搜索树的层序遍历
    public void levelOrder() {
        // 我们使用LinkedList来作为我们的队列
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.key);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }


}
