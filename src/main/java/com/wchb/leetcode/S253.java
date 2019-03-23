package com.wchb.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @date 8/10/18 10:37 PM
 */
public class S253 {

    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        if (n <= 1) return n;

        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(intervals[0].end);

        for (int i = 1; i < n; i++) {
            if (intervals[i].start >= heap.peek()) {
                heap.poll();
            }
            heap.add(intervals[i].end);
        }

        return heap.size();
    }

    public class Interval {
        public int start;
        public int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
