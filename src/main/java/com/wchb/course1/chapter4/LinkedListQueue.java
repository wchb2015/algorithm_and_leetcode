package com.wchb.course1.chapter4;

import com.wchb.course1.chapter3.IQueue;

public class LinkedListQueue<E> implements IQueue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private Integer size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }


    //链表入队, 从尾部进行.
    @Override
    public void enqueue(E e) {

        // tail 为null,也说明 head 为null.
        // 只要有元素, tail指向尾节点的位置
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            //这样入队不需要考虑头结点
            tail.next = new Node(e);
            tail = tail.next;
        }

        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot dequeue from an empty queue");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        size--;

        if (head == null) {
            //queue size =1 ,dequeue以后list为空, tail,head both point to the first element.
            tail = null;//如果不执行这行代码 tail依然指向retNode.
        }
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot getFront Element from an empty queue");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" LinkedListQueue Front : ");
        Node cur = head;

        while (cur != null) {
            sb.append(cur + "->");

            cur = cur.next;
        }

        sb.append("NULL tail");
        return sb.toString();
    }
}