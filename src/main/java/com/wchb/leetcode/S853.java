package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 12/7/18 1:06 PM
 */
public class S853 {
    public int carFleet(int target, int[] position, int[] speed) {

        int N = position.length;
        if (N <= 1) return N;
        Car[] cars = new Car[N];
        for (int i = 0; i < N; ++i)
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

        int ans = 1, t = N;
        while (--t > 0) {
            if (cars[t].time < cars[t - 1].time) ans++; //if cars[t] arrives sooner, it can't be caught
            else cars[t - 1] = cars[t]; //else, cars[t-1] arrives at same time as cars[t]
        }

        return ans;
    }
}

class Car {
    int position;
    double time;

    Car(int p, double t) {
        position = p;
        time = t;
    }
}