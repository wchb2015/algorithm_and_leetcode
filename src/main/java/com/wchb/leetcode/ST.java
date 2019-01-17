package com.wchb.leetcode;

import java.util.*;


/**
 * @date 12/29/18 12:27 PM
 */
public class ST {
    public int minProduct(int smaller, int bigger) {
        if (smaller == 0) return 0;
        if (smaller == 1) return bigger;


        int s = smaller >> 1;//divided by 2;

        int side1 = minProduct(s, bigger);
        int side2 = side1;

        if (smaller % 2 == 1) {
            side2 = minProduct(smaller - s, bigger);
        }

        return side1 + side2;
    }
}
