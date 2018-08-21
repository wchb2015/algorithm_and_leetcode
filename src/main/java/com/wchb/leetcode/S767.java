package com.wchb.leetcode;

import java.util.PriorityQueue;

/**
 * @date 8/20/18 3:45 PM
 */
public class S767 {
    public String reorganizeString(String S) {

        char[] chars = new char[26];

        for (char c : S.toCharArray()) {
            chars[c - 'a']++;
            if (chars[c - 'a'] > (S.length() + 1) / 2) return "";
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                pq.add(new int[]{i + 97, chars[i]});
            }
        }

        StringBuffer ans = new StringBuffer();
        while (!pq.isEmpty()) {
            int[] first = pq.remove();
            if (ans.length() == 0 || first[0] != ans.charAt(ans.length() - 1)) {
                ans.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.remove();
                ans.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }

        return ans.toString();
    }


    public String reorganizeStringV2(String S) {
        char ch[] = new char[26];
        int max = 0;
        for (char c : S.toCharArray()) {
            ch[c - 'a']++;
            if (ch[c - 'a'] > ch[max]) max = c - 'a';
        }
        int len = S.length();
        if (len < 2 * ch[max] - 1) return "";
        int index = 0;
        char[] res = new char[len];
        for (int i = 0; i < ch[max]; i++) {
            res[index] = (char) (max + 'a');
            index += 2;
        }
        ch[max] = 0;
        for (int i = 0; i < 26; i++) {
            int count = ch[i];
            while (count > 0) {
                if (index >= len) index = 1;
                res[index] = (char) (i + 'a');
                index += 2;
                count--;
            }
        }

        return new String(res);
    }
}
