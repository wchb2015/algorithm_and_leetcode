package com.wchb.course1.chapter7;

public interface IMap<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    Integer getSize();

    boolean isEmpty();

}
