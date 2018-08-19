package com.wchb.leetcode;


import java.util.*;

/**
 * @date 8/18/18 11:06 PM
 */
public class S658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Dif> pq = new PriorityQueue<>((d1, d2) -> {
            if (d1.dif == d2.dif) {
                return d1.ele - d2.ele;
            } else {
                return d1.dif - d2.dif;
            }
        });

        for (int i : arr) {
            pq.add(new Dif(i, Math.abs(i - x)));
        }

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) list.add(pq.remove().ele);
        Collections.sort(list);

        return list;
    }


    private class Dif {
        int ele;
        int dif;

        public Dif(int ele, int dif) {
            this.ele = ele;
            this.dif = dif;
        }
    }
}
