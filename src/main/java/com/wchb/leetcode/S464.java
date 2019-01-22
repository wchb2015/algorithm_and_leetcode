package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 1/22/19 8:30 AM
 */
public class S464 {
    boolean[] used;
    Map<String, Boolean> map;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        used = new boolean[maxChoosableInteger + 1];
        map = new HashMap<>();

        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;

        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;

        boolean ret = helper(desiredTotal);

        System.out.println(map);
        return ret;
    }

    private boolean helper(int desiredTotal) {
        if (desiredTotal <= 0) return false;
        String key = getKey(used);
        System.out.println(key);

        if (map.get(key) != null) {
            System.out.println("========= " + key);
            return map.get(key);
        }

        // try every un chosen number as next step
        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                // check whether this lead to a win (i.e. the other player lose)
                if (!helper(desiredTotal - i)) {
                    used[i] = false;
                    map.put(key, true);
                    return true;
                }


                used[i] = false;
            }
        }

        map.put(key, false);
        return false;
    }

    private String getKey(boolean[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] ? "t" : "f");
        }
        return sb.toString();
    }
}
