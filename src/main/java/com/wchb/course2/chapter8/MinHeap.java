package com.wchb.course2.chapter8;

import com.wchb.course2.util.SortHelper;

/**
 * @date 6/14/18 12:35 PM
 */

// 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
public class MinHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 构造函数, 通过一个给定数组创建一个最小堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MinHeap(Item arr[]) {

        int n = arr.length;

        data = (Item[]) new Comparable[n + 1];
        capacity = n;

        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k; // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) < 0) {
                j++;
            }
            // data[j] 是 data[2*k]和data[2*k+1]中的最小值

            if (data[k].compareTo(data[j]) <= 0) {
                break;
            }
            SortHelper.swap(data, k, j);
            k = j;
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

    // 向最小堆中插入一个新的元素 item
    public void insert(Item item) {

        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) > 0) {
            SortHelper.swap(data, k, k / 2);
            k /= 2;
        }
    }

    // 从最小堆中取出堆顶元素, 即堆中所存储的最小数据
    public Item extractMin() {
        assert count > 0;
        Item ret = data[1];

        SortHelper.swap(data, 1, count);
        count--;
        shiftDown(1);

        return ret;
    }

    // 获取最小堆中的堆顶元素
    public Item getMin() {
        assert (count > 0);
        return data[1];
    }

}
