package com.wchb.leetcode;

import java.util.LinkedList;

/**
 * @date 12/7/18 11:47 AM
 */
public class S855 {
    int n;
    LinkedList<Integer> list;

    public S855(int n) {
        this.n = n;
        list = new LinkedList<>();
    }

    public int seat() {
        if (list.size() == 0) {
            list.add(0);
            return 0;
        }


        int d = Math.max(list.getFirst(), n - 1 - list.getLast());
        for (int i = 0; i < list.size() - 1; ++i) d = Math.max(d, (list.get(i + 1) - list.get(i)) / 2);
        if (list.getFirst() == d) {
            list.addFirst(0);
            return 0;
        }
        for (int i = 0; i < list.size() - 1; ++i) {
            if ((list.get(i + 1) - list.get(i)) / 2 == d) {
                list.add(i + 1, (list.get(i + 1) + list.get(i)) / 2);
                return list.get(i + 1);
            }
        }

        list.add(n - 1);
        return n - 1;
    }

    public void leave(int p) {
        for (int i = 0; i < list.size(); ++i) if (list.get(i) == p) list.remove(i);
    }
}
