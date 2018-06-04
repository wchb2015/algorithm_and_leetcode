package com.wchb.course2.chapter4;

/**
 * @date 6/2/18 3:14 PM
 */
public class HeapSort1 {

    private HeapSort1() {
    }


    // 对整个arr数组使用HeapSort1排序
    // HeapSort1, 将所有元素依次添加到堆中, 再讲所有元素从堆中依次取出来, 即完成了排序.
    // 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
    // 整个堆排序的整体时间复杂度为O(nlogn)

    public static void sort(Comparable[] arr) {

        int length = arr.length;

        MaxHeap<Comparable> maxHeap = new MaxHeap<>(length);

        for (int i = 0; i < length; i++) {
            maxHeap.add(arr[i]);
        }

        //从小到大排序
        for (int i = length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }

    }
}
