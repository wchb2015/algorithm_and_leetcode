package com.wchb.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 8/10/18 10:37 PM
 */
public class S253 {

    public int minMeetingRooms(Interval[] intervals) {

        int n = intervals.length;
        if (n <= 1) return n;

        int ans = 0;
        int numSimultaneousEvents = 0;
        List<Point> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Point(intervals[i].start, true));
            list.add(new Point(intervals[i].end, false));
        }

        Collections.sort(list, (p1, p2) -> p1.time == p2.time ? p1.isStart ? -1 : 1 : p1.time - p2.time);

        for (int i = 0; i < 2 * n; i++) {
            if (list.get(i).isStart) {
                numSimultaneousEvents++;
                ans = Math.max(ans, numSimultaneousEvents);
            } else {
                numSimultaneousEvents--;
            }
        }

        return ans;
    }


    class Point {
        int time;
        boolean isStart;

        Point(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

//    public int minMeetingRooms(Interval[] intervals) {
//        int[] start = new int[intervals.length];
//        int[] end = new int[intervals.length];
//        for (int i = 0; i < intervals.length; i++) {
//            start[i] = intervals[i].start;
//            end[i] = intervals[i].end;
//        }
//        Arrays.sort(start);
//        Arrays.sort(end);
//        int endIdx = 0, res = 0;
//        for (int i = 0; i < start.length; i++) {
//            if (start[i] < end[endIdx]) res++;
//            else endIdx++;
//        }
//        return res;
//    }


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
