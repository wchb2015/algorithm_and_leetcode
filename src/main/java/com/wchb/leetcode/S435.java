package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 7/26/18 2:37 PM
 */
public class S435 {

    //T: O(n^2);
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);

        int n = intervals.length;

        if (n <= 1) return 0;

        int[] mem = new int[n];
        Arrays.fill(mem, 1);


        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isNonOverlapping(intervals[j], intervals[i])) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
        }

        Arrays.sort(mem);
        return n - mem[n - 1];

        // System.out.println(Arrays.toString(mem));
    }

    private boolean isNonOverlapping(Interval i1, Interval i2) {
        return i2.start >= i1.end;
    }

    /************************************************************/
    //贪心算法:按照区间的结尾排序,每次选择结尾最早的,且和前一个区间不重叠的区间
    //T:o(n);
    public int eraseOverlapIntervalsV2(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1.end - i2.end);

        int n = intervals.length;

        if (n <= 1) return 0;

        int res = 1;
        int pre = 0;

        for (int i = 1; i < n; i++) {
            if (intervals[i].start >= intervals[pre].end) {
                res++;
                pre = i;
            }
        }
        return n - res;
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
