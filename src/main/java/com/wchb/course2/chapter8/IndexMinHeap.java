package com.wchb.course2.chapter8;

/**
 * @date 6/14/18 9:35 PM
 */

// 最小索引堆
public class IndexMinHeap<Item extends Comparable> {

    private Item[] data;      // 最小索引堆中的数据
    private int[] indexes;    // 最小索引堆中的索引, indexes[x] = i 表示索引i在x的位置
    private int[] reverse;    // 最小索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置
    private int count;
    private int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public IndexMinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
        count = 0;
        this.capacity = capacity;
    }

    // 返回索引堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示索引堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向最小索引堆中插入一个新的元素, 新元素的index为i, 元素为item
    public void insert(int i, Item item) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;
        // 再插入一个新元素前,还需要保证索引i所在的位置是没有元素的。
        assert !contain(i);

        i += 1;//传入的i对用户来讲是从0开始的.
        data[i] = item;
        indexes[count + 1] = i;


    }

    private boolean contain(int i) {
        return false;
    }


}
