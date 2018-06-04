package com.wchb.course2.chapter4;

/**
 * @date 5/31/18 1:02 PM
 */
// 在堆的有关操作中,需要比较堆中元素的大小,所以T需要extends Comparable
public class MaxHeap<T extends Comparable> {

    private T[] data;
    private int count;
    protected int capacity;

    public MaxHeap(int capacity) {
        data = (T[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 通过一个给定的数组创建一个最大堆
    // 该构造堆的过程,时间复杂度为O(n)
    public MaxHeap(T arr[]) {
        int n = arr.length;
        data = (T[]) new Comparable[n + 1];
        capacity = n;

        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }

        count = n;

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 像最大堆中插入一个新的元素 item
    public void add(T item) {
        if (count + 1 > capacity) {
            throw new RuntimeException("MaxHeap is full!");
        }
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //最大堆核心辅助函数
    private void shiftUp(int k) {
        while (k > 1 && data[parent(k)].compareTo(data[k]) < 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    private int parent(int k) {

        if (k < 1) {
            throw new IllegalArgumentException(" k should larger than 1");
        }
        if (k == 1) {
            return 1;
        }

        return k / 2;
    }

    public T[] getData() {
        return data;
    }

    public T extractMax() {
        if (isEmpty()) {
            throw new RuntimeException(" Heap is empty");
        }

        T ret = data[1];

        swap(1, count);
        count--;

        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {
        //k节点当前有孩子.
        while (count >= 2 * k) {
            int j = 2 * k;//在此轮循环中,data[j] 和 data[k]交换位置
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }
}
