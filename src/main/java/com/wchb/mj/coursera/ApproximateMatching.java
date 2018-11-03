package com.wchb.mj.coursera;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @date 11/2/18 8:27 PM
 */
public class ApproximateMatching {
    public String solution(String text, String prefix, String suffix) {
        String res = null;
        int overlap = 0;
        int overlapPrefix = 0;

        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                String sub = text.substring(i, j + 1); // length = j-1
                int pOverlap = getOverlap(prefix, sub);
                int sOverlap = getOverlap(sub, suffix);


                if (overlap < pOverlap + sOverlap) {
                    overlap = pOverlap + sOverlap;
                    overlapPrefix = pOverlap;
                    res = sub;

                } else if (overlap == pOverlap + sOverlap) {
                    if (overlapPrefix < pOverlap) {
                        overlapPrefix = pOverlap;
                        res = sub;
                    } else if (overlapPrefix == pOverlap) {
                        res = (res.compareTo(sub) == 1) ? sub : res;
                    }

                }
            }
        }
        return res;
    }

    private static int getOverlap(String first, String second) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (i + j == first.length() || j == second.length()) return j;
                if (first.charAt(i + j) != second.charAt(j)) break;
            }
        }
    }


    public String solution2(String text, String prefix, String suffix) {
        int n = text.length();
        int sl = suffix.length();
        int pl = prefix.length();


        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {

                String sub = text.substring(i, j);

                int ps = 0, ss = 0, subL = sub.length();

                for (int k = 0; k < subL; k++) {
                    if (subL - k <= sl) {
                        if (sub.substring(k).equals(suffix.substring(0, subL - k))) {
                            ps = Math.max(subL - k, ps);
                        }
                    }
                }

                for (int k = 0; k < subL; k++) {
                    if (k < pl) {
                        if (sub.substring(0, k + 1).equals(prefix.substring(pl - k - 1, pl))) {
                            ss = Math.max(k + 1, ss);
                        }
                    }
                }

                if (map.get(sub) == null) {
                    map.put(sub, ps + ss);
                } else {
                    map.put(sub, Math.max(map.get(sub), ps + ss));
                }
            }
        }
        int m = -1;
        Set<String> keys = map.keySet();

        String[] arr = keys.toArray(new String[keys.size()]);

        Arrays.sort(arr);
        String ans = null;
        for (int i = 0; i < arr.length; i++) {
            if (m < map.get(arr[i])) {
                ans = arr[i];
                m = map.get(arr[i]);
            }
        }

        return ans;
    }


    public String solution3(String text, String prefix, String suffix) {
        int n = text.length(), sl = suffix.length(), pl = prefix.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = text.substring(i, j + 1);
                int ps = 0, ss = 0, subLength = sub.length();
                for (int l = 0; l < subLength; l++) {
                    if (subLength - l <= sl && sub.substring(l) == suffix.substring(0, subLength - l))
                        ps = Math.max(subLength - l, ps);
                }

                for (int l = 0; l < subLength; l++) {
                    if (l < pl && sub.substring(0, l + 1) == prefix.substring(pl - l - 1, 2 * pl - l - 1))
                        ss = Math.max(l + 1, ss);
                }

                if (map.get(sub) == null)
                    map.put(sub, ps + ss);
                else
                    map.put(sub, Math.max(map.get(sub), ps + ss));
            }
        }

        int m = -1;
        Set<String> keys = map.keySet();

        String[] arr = keys.toArray(new String[keys.size()]);

        Arrays.sort(arr);
        String ans = null;
        for (int i = 0; i < arr.length; i++) {
            if (m < map.get(arr[i])) {
                ans = arr[i];
                m = map.get(arr[i]);
            }
        }

        return ans;

    }
}
