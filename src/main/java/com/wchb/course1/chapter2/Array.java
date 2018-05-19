package com.wchb.course1.chapter2;

import java.util.Arrays;

public class Array<E> {

    private E[] data;

    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }


    // 第targetIndex个位置插入一个新元素e
    public void add(E e, int targetIndex) {

        if (targetIndex > size || targetIndex < 0) {
            throw new IllegalArgumentException();
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size; i > targetIndex; i--) {
            data[i] = data[i - 1];
        }

        data[targetIndex] = e;

        size++;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        return data[index];
    }

    //修改index位置的元素为e
    public void set(int index, E e) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (E i : data) {
            if (i.equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引,如果不存在元素e,则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //删除指定位置的元素,且返回给用户
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }

        E result = data[index];
        for (int i = index; i + 1 < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length > 1000) {
            resize(data.length / 2);
        }

        return result;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index > 0) {
            remove(index);
        }
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void swap(int i, int j) {

        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new RuntimeException("Index is illegal");
        }

        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;

    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + data.length +
                '}';
    }


}
