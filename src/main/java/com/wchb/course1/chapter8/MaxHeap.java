package com.wchb.course1.chapter8;

import com.wchb.course1.chapter2.Array;

import java.util.Objects;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr) {
        if (arr.length == 0) {
            return;
        }

        data = new Array<>(arr);

        int j = parent(data.getSize() - 1);

        for (int i = j; i >= 0; i--) {
            siftDown(i);
        }
    }

    public MaxHeap() {
        data = new Array<>();
    }

    //返回堆中的元素个数
    public Integer size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中, 一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中, 一个索引所表示的元素的右孩子的索引
    private int rightChildren(int index) {
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // 取出堆中最大元素
    public E extractMax() {

        E ret = findMax();

        if (Objects.nonNull(data.get(data.getSize() - 1))) {
            data.swap(0, data.getSize() - 1);
            data.removeLast();
            siftDown(0);
        }

        return ret;
    }

    //取出堆中的最大元素, 并替换成元素e
    public E replace(E e) {
        E ret = findMax();

        data.set(0, e);
        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {


        // k 有左孩子
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChildren(k);
                //data[j] 是leftChild 和 rightChild 中的最大值
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }

    }

    private void siftUp(int k) {

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot findMax when heap is empty");
        }
        return data.get(0);
    }

}
