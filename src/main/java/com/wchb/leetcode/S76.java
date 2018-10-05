package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @date 8/6/18 4:08 PM
 */
public class S76 {
    public String minWindow(String s, String t) {

        int[] tFreq = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }

        int[] sFreq = new int[256];
        int sCnt = 0;

        int minLength = s.length() + 1;
        int startIndex = -1;

        int l = 0, r = -1;

        while (l < s.length()) {
            if (r + 1 < s.length() && sCnt < t.length()) {
                sFreq[s.charAt(r + 1)]++;
                if (sFreq[s.charAt(r + 1)] <= tFreq[s.charAt(r + 1)])
                    sCnt++;
                r++;
            } else {
                assert (sCnt <= t.length());
                if (sCnt == t.length() && r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    startIndex = l;
                }

                sFreq[s.charAt(l)]--;
                if (sFreq[s.charAt(l)] < tFreq[s.charAt(l)])
                    sCnt--;
                l++;
            }
        }


        if (startIndex != -1)
            return s.substring(startIndex, startIndex + minLength);

        return "";
    }


    /**
     * 1. We start with two pointers, left and right initially pointing to the first element of the string S.
     * <p>
     * 2. We use the right pointer to expand the window until we get a desirable window i.e. a window that contains all of the characters of T.
     * <p>
     * 3. Once we have a window with all the characters, we can move the left pointer ahead one by one. If the window is still a desirable one we keep on updating the minimum window size.
     * <p>
     * If the window is not desirable any more, we repeat step step2 onwards.
     *
     * @param s
     * @param t
     * @return
     */

    public String minWindowV2(String s, String t) {

        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : t.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }

        int matchCount = 0;
        int minLen = Integer.MAX_VALUE;
        int sp = 0;
        int start = 0;

        for (int fp = 0; fp < s.length(); fp++) {
            char c = s.charAt(fp);

            Integer count = map.get(c);
            if (count == null) continue;
            if (count == 1) matchCount++;
            map.put(c, count - 1);

            while (matchCount == map.size()) {
                if (fp - sp + 1 < minLen) {
                    minLen = fp - sp + 1;
                    start = sp;
                }

                char left = s.charAt(sp++);
                Integer leftCount = map.get(left);
                if (leftCount == null) continue;
                map.put(left, leftCount + 1);

                if (leftCount == 0) {
                    matchCount--;
                }
            }
        }


        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);

    }

}