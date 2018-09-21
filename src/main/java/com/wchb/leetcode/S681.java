package com.wchb.leetcode;


/**
 * @date 9/20/18 9:25 PM
 */
public class S681 {
    public String nextClosestTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        while (true) {
            min++;
            if (min == 60) {
                min = 0;
                hour++;
                hour %= 24;
            }
            String curr = String.format("%02d:%02d", hour, min);
            Boolean valid = true;
            for (int i = 0; i < curr.length(); ++i)
                if (time.indexOf(curr.charAt(i)) < 0) {
                    valid = false;
                    break;
                }
            if (valid) return curr;
        }
    }
}
