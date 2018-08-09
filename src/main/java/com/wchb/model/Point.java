package com.wchb.model;

import lombok.ToString;

/**
 * @date 8/8/18 4:30 PM
 */


@ToString
public class Point {
    public int x;
    public int y;

    public Point(int a, int b) {
        x = a;
        y = b;
    }


}
