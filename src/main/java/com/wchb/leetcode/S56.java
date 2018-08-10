package com.wchb.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 8/9/18 7:42 AM
 */
public class S56 {

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() <= 1) return intervals;

        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

        LinkedList<Interval> res = new LinkedList<>();

        res.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval lastInterval = res.getLast();
            Interval curInterval = intervals.get(i);
            if (cross(lastInterval, curInterval)) {
                Interval newInterval = mergeInterval(lastInterval, curInterval);
                res.removeLast();
                res.addLast(newInterval);
            } else {
                res.addLast(curInterval);
            }
        }

        return res;
    }


    private boolean cross(Interval i1, Interval i2) {
        return i2.start <= i1.end;
    }

    private Interval mergeInterval(Interval i1, Interval i2) {
        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
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
