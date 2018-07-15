package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @date 7/14/18 4:37 PM
 */
public class S272 {

    private class Pair implements Comparable<Pair> {
        public double dif;
        public int val;

        public Pair(double dif, int val) {
            this.dif = dif;
            this.val = val;
        }

        @Override
        public int compareTo(Pair ano) {
            return new Double(this.dif).compareTo(new Double(ano.dif));
        }

        @Override
        public String toString() {
            return val + "---" + dif;
        }

    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        PriorityQueue<Pair> q = new PriorityQueue<>();

        inOrder(root, target, q);

        LinkedList<Integer> list = new LinkedList<>();

        System.out.println(q);
        while (k > 0) {
            list.add(q.remove().val);
            k--;
        }

        return list;
    }

    private void inOrder(TreeNode root, double target, PriorityQueue<Pair> q) {
        if (root == null) {
            return;
        }

        inOrder(root.left, target, q);
        q.add(new Pair(Math.abs(target - root.val), root.val));
        inOrder(root.right, target, q);
    }
}
