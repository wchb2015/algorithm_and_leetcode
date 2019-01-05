package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 1/4/19 10:14 AM
 */
public class S248 {
    HashMap<Character, Character> map = new HashMap<>();

    int count = 0;

    public int strobogrammaticInRange(String low, String high) {
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        int L1 = low.length();
        int L2 = high.length();

        for (int len = L1; len <= L2; len++) {
            char[] path = new char[len];
            dfs(low, high, path, 0, len - 1);
        }

        return count;
    }

    private void dfs(String low, String high, char[] path, int left, int right) {

        if (left > right) {
            String pathStr = new String(path);
            if ((pathStr.length() == high.length() && pathStr.compareTo(high) > 0) ||
                    (pathStr.compareTo(low) < 0 && pathStr.length() == low.length())) {
                return;
            }
            count++;
            return;
        }

        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            path[left] = entry.getKey();
            path[right] = entry.getValue();
            if (path.length != 1 && path[0] == '0') {
                continue;
            }
//            if (left == right && path[0] != path[1]) {
//                continue;
//            }


            if (left == right && path.length > 1 && (path[left] == '6' || path[left] == '9')) {
                continue;
            }

            dfs(low, high, path, left + 1, right - 1);
        }

    }


}
