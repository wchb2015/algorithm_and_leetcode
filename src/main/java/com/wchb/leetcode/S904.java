package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 9/20/18 8:32 PM
 */
public class S904 {

    Map<Integer, Integer> map;

    public int totalFruit(int[] tree) {
        int ans = 0;
        int n = tree.length;

        if (n <= 2) return n;
        map = new HashMap<>();

        int i = 0;
        int j = 0;

        while (j < n) {
            if (!map.containsKey(tree[j])) map.put(tree[j], 1);
            else {
                map.put(tree[j], map.get(tree[j]) + 1);
            }
            if (map.size() == 3) {
                System.out.println(j - i);

                System.out.println(j - i + "----" + i + "-----" + j);
                ans = Math.max(j - i, ans);

                while (i < j) {
                    map.put(tree[i], map.get(tree[i]) - 1);
                    if (map.get(tree[i]) == 0) {
                        map.remove(tree[i]);
                    }
                    i++;

                    if (map.size() == 2) break;
                }
            }
            j++;
        }


        ans = Math.max(ans, j - i);
        return ans;
    }
}
