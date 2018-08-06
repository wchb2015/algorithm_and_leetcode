package com.wchb.leetcode;


/**
 * @date 8/5/18 10:02 PM
 */
public class S277 {
    public int findCelebrity(int n) {

        //1. Find  a candidate by one pass: (make sure other people are not celebrity).
        //2. Make sure if the candidate is a celebrity by one pass.

        // if(knows(a,b)==> a不是celebrity

        int celebrity = 0;

        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }


        for (int i = 0; i < n; i++) {
            if (i == celebrity) continue;
            if (!knows(i, celebrity) || knows(celebrity, i)) return -1;
        }

        return celebrity;
    }


    boolean knows(int a, int b) {
        return true;
    }
}