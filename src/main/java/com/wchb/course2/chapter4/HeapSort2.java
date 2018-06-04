package com.wchb.course2.chapter4;

/**
 * @date 6/2/18 3:38 PM
 */
public class HeapSort2 {

    // 我们的算法类不允许产生任何实例
    private HeapSort2() {
    }

    // 对整个数组使用HeapSort2排序
    // HeapSort2, 借助heapify过程创建堆
    // 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 时间复杂度为O(nlogn)
    // 堆排序的总体时间复杂度是O(nlogn),但是比HeapSort1性能更优, 因为创建堆的性能更优.
    public static void sort(Comparable[] arr) {
        int length = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);

        for (int i = length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }
}
