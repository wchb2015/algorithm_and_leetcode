package com.wchb.course1.chapter3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoopQueue<E> implements IQueue<E> {

    private static final Logger logger = LoggerFactory.getLogger(LoopQueue.class);

    private E[] data;

    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {

        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;

        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Empty Queue cannot finish dequeue action");
        }
        E e = data[front];
        data[front] = null;

        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 4 > 100) {
            resize(getCapacity() / 2);
        }

        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Queue!");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Loop Queue: ").append("FRONT[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("]TAIL, size: ").append(size).append(", capacity: ").append(getCapacity());
        return sb.toString();
    }

    private void resize(int newCapacity) {

//        logger.info(" resize, queue:{}, tail: {},front:{}", this.toString(), tail, front);

        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        this.data = newData;
        front = 0;
        tail = size;
    }

    public int getTail() {
        return tail;
    }

    public int _getFront() {
        return front;
    }
}
