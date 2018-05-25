package com.wchb.course1.chapter4;

public class LinkedList<E> {

    private Node dummyHead;

    private Integer size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

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

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作,练习用
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public E get(Integer index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, Illegal index");
        }

        Node currentNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.e;
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed, Illegal index");
        }

        Node currentNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        currentNode.e = e;
    }

    public E remove(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed, Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;

        prev.next = delNode.next;
        delNode.next = null;

        size--;

        return delNode.e;
    }

    // 从链表中删除元素e
    public void removeElement(E e) {

        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(" LinkedList:{ ");

        Node current = dummyHead.next;
        while (current != null) {
            sb.append(current.e).append("->");
            current = current.next;
        }

/*        for(Node cur = dummyHead.next;cur!=null;cur = cur.next){
            sb.append(current.e).append("->");
        }*/

        sb.append("NULL} ,size: ").append(getSize());

        return sb.toString();
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(getSize() - 1);
    }

    public Integer getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }
}
