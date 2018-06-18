package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 6/17/18 10:37 PM
 */
public class S447 {
    public int numberOfBoomerangs(int[][] points) {

        int ret = 0;
        for (int i = 0; i < points.length; i++) {
            //map 中存储 点i 到所有其他点的距离出现的频次
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int distance = dis(points[i], points[j]);
                    if (map.containsKey(distance)) {
                        map.put(distance, map.get(distance) + 1);
                    } else {
                        map.put(distance, 1);
                    }
                }
            }
            System.out.println(map);
            for (Integer dis : map.keySet()) {
                ret += map.get(dis) * (map.get(dis) - 1);
            }
        }


        return ret;
    }

    private int dis(int[] a, int[] b) {
        return (int) (Math.pow((a[0] - b[0]), 2) +
                Math.pow((a[1] - b[1]), 2));
    }
}
