package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/22/18 9:26 PM
 */
public class S401 {

    List<String> ret;
    int timeCode[];

    public List<String> readBinaryWatch(int num) {
        ret = new LinkedList<>();
        timeCode = new int[10];
        dfs(timeCode, 0, 0, num);
        return ret;
    }

    private void dfs(int[] timeCode, int start, int k, int num) {
        if (k == num) {
            String res = decodeToTime(timeCode);
            if (res != null) ret.add(res);
            return;
        }
        if (start == timeCode.length) return;

        timeCode[start] = 1;
        dfs(timeCode, start + 1, k + 1, num);
        timeCode[start] = 0;
        dfs(timeCode, start + 1, k, num);
    }

    private String decodeToTime(int[] timeCode) {
        int hours = 0, minutes = 0;
        for (int i = 0; i < 10; i++) {
            if (timeCode[i] == 0) continue;
            if (i < 4) {
                hours += (int) Math.pow(2, i);
            } else {
                minutes += (int) Math.pow(2, i - 4);
            }
        }
        if (hours > 11 || minutes > 59) return null;
        return hours + (minutes < 10 ? ":0" : ":") + minutes;

    }

}
