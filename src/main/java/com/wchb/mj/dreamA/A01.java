package com.wchb.mj.dreamA;


import java.util.PriorityQueue;

/**
 * @date 3/12/19 4:49 PM
 */
public class A01 {

    /*
    merge N files to 1 file, can only merge two files at one time,
    merge time is the sum of two files size, given a list of file size,
     return the min merge time.
     */

    public int mergeFiles(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int ans = 0;

        for (int i : arr) q.offer(i);

        while (!q.isEmpty()) {
            int f1 = q.poll();
            int f2 = q.poll();

            if (!q.isEmpty()) {
                q.offer(f1 + f2);
            }
            ans += (f1 + f2);
        }

        return ans;
    }
}
