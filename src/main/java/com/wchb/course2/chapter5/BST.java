package com.wchb.course2.chapter5;

import com.wchb.annotations.CreatedByMyself;

import java.util.Objects;

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
        insert(root, key, value);
    }

    // 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
    // 返回插入新节点后的二分搜索树的根
    private Node insert(Node root, Key key, Value value) {
        if (root == null) {
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(root.key) == 0) {
            root.value = value;
        } else if (key.compareTo(root.key) < 0) {
            root.left = insert(root.left, key, value);
        } else {
            // key > node->key
            root.right = insert(root.right, key, value);
        }
        return root;
    }

    @CreatedByMyself
    private Node insert1(Node root, Key key, Value value) {
        if (Objects.isNull(root) || Objects.isNull(key)) {
            return root;
        }

        //递归到底的情况
        if (root.key.compareTo(key) > 0 && Objects.isNull(root.left)) {
            root.left = new Node(key, value);
            return root;
        } else if (root.key.compareTo(key) < 0 && Objects.isNull(root.right)) {
            root.right = new Node(key, value);
            return root;
        } else if (root.key.compareTo(key) == 0) {
            root.value = value;
            return root;
        }

        //递归
        if (root.key.compareTo(key) > 0) {
            return insert(root.left, key, value);
        } else if (root.key.compareTo(key) < 0) {
            return insert(root.right, key, value);
        }
        return root;
    }

    // 查看二分搜索树中是否存在键key
    public boolean contain(Key key) {
        return contain(root, key);
    }

    private boolean contain(Node root, Key key) {
        if (Objects.isNull(root)) {
            return false;
        }

        if (root.key.compareTo(key) == 0) {
            return true;
        } else if (root.key.compareTo(key) > 0) {
            return contain(root.left, key);
        } else {
            //root.key.compareTo(key) < 0
            return contain(root.right, key);
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
        } else if (root.key.compareTo(key) > 0) {
            return search(root.left, key);
        } else {
            //root.key.compareTo(key) < 0
            return search(root.right, key);
        }
    }


}
