package com.wchb.mj;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @date 10/31/18 11:31 AM
 */

// Coursera
public class RoyalName {
    public String[] solution(String[] names) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (p1, p2) -> p1.name.compareTo(p2.name) == 0 ? p1.num - p2.num : p1.name.compareTo(p2.name));

        for (int i = 0; i < names.length; i++) {

            String[] arr = names[i].split(" ");

            pq.add(new Pair(arr[0], romanToInt(arr[1]), arr[1]));

        }

        String[] ans = new String[names.length];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            ans[i++] = temp.name + " " + temp.gen;
        }


        return ans;
    }


    private class Pair {
        String name;
        int num;
        String gen;

        public Pair(String name, int num, String gen) {
            this.name = name;
            this.num = num;
            this.gen = gen;
        }
    }


    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int m2 = 0, m20 = 0, m200 = 0, sum = 0;

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; ) {
            if (i + 1 < arr.length) {
                boolean flag = false;
                if ((arr[i] == 'I') && (arr[i + 1] == 'V' || arr[i + 1] == 'X')) {
                    m2++;
                } else if ((arr[i] == 'X') && (arr[i + 1] == 'L' || arr[i + 1] == 'C')) {
                    m20++;
                } else if ((arr[i] == 'C') && (arr[i + 1] == 'D' || arr[i + 1] == 'M')) {
                    m200++;
                }
                if (flag) {
                    sum += map.get(arr[i]);
                    sum += map.get(arr[i + 1]);
                    i += 2;
                }
            }

            sum += map.get(arr[i]);
            i++;
        }


        return sum - m2 * 2 - m20 * 20 - m200 * 200;

    }
}
