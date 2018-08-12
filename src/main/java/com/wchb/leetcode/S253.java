package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 8/10/18 10:37 PM
 */
public class S253 {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endIdx = 0, res = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] < end[endIdx]) res++;
            else endIdx++;
        }
        return res;
    }


    public class Interval {
        int start;
        int end;

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
