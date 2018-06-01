package com.wchb.course1.chapter8;

import com.wchb.course1.chapter2.Array;

import java.util.Objects;


/**
 * 底层实现为动态数组的最大堆
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
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

    //返回堆中的元素个数
    public Integer size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中, 一个索引所表示的元素的父亲节点的索引
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

    // k为需要上浮的元素的索引值
    private void siftUp(int k) {
        while (k > 0
                && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);//为下一轮做准备,当前的K已经来到了新的位置
        }
    }

    // 取出堆中最大元素(根节点)
    public E extractMax() {
        E ret = findMax();
        if (Objects.nonNull(data.get(data.getSize() - 1))) {
            data.swap(0, data.getSize() - 1);
            data.removeLast();
            siftDown(0);
        }
        return ret;
    }

    //siftDown的逻辑, root和较大的子元素交换位置
    private void siftDown(int k) {

        // k 有左孩子 if(leftChild(k) > data.getSize()) 说明已经越界了. 右孩子更大.
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);

            //j + 1 < data.getSize()说明有右孩子,在这种情况下,比较左右孩子的值
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChildren(k);
                //data[j] 是leftChild 和 rightChild 中的最大值
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;//这种情况说明没有违反堆的性质
            }
            data.swap(k, j);
            k = j;
        }
    }

    //取出堆中的最大元素, 并替换成元素e
    public E replace(E e) {
        E ret = findMax();

        data.set(0, e);
        siftDown(0);

        return ret;
    }

    public E findMax() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot findMax when heap is empty");
        }
        return data.get(0);
    }

}
