package com.wchb.leetcode;

import com.wchb.model.Point;

import java.util.*;

/**
 * @date 8/8/18 10:35 AM
 */
public class S149 {

    List<List<Integer>> pointCombination;
    Map<Float, Set<Integer>> map;
    Map<Integer, Set<Integer>> xMap;

    int ret = 0;


    public int maxPoints(Point[] points) {

        if (points.length <= 2) return points.length;

        pointCombination = new LinkedList<>();
        map = new HashMap<>();
        xMap = new HashMap<>();
        dfs(points, 0, new LinkedList<>());

        for (List<Integer> pointList : pointCombination) {
            if (points[pointList.get(0)].x != points[pointList.get(1)].x) {
                float rate = calRate(points[pointList.get(0)], points[pointList.get(1)]);
                if (!map.containsKey(rate)) {
                    map.put(rate, new HashSet<>());
                }

                if (new Float(5.0).equals(rate)) {
                    System.out.println(pointList.get(0) + "---" + pointList.get(1));
//                    System.out.println(points[pointList.get(0)] + " ## " + points[pointList.get(1)]
//                            + " ## " + rate);
                }


                map.get(rate).add(pointList.get(0));
                map.get(rate).add(pointList.get(1));
                ret = Math.max(ret, map.get(rate).size());

            } else {
                int key = points[pointList.get(0)].x;
                if (!xMap.containsKey(key)) {
                    xMap.put(key, new HashSet<>());
                }
                xMap.get(key).add(pointList.get(0));
                xMap.get(key).add(pointList.get(1));
                ret = Math.max(ret, xMap.get(key).size());
            }
        }

        return ret;
    }

    private float calRate(Point point1, Point point2) {
        return ((float) point1.y - (float) point2.y) / ((float) point1.x - (float) point2.x);
    }

    private void dfs(Point[] points, int index, LinkedList<Integer> path) {

        if (path.size() == 2) {
            pointCombination.add((List<Integer>) path.clone());
            return;
        }

        for (int i = index; i < points.length; i++) {

            path.add(i);
            dfs(points, i + 1, path);//一定注意是i+1,不是index+1
            path.removeLast();

        }
    }

}
