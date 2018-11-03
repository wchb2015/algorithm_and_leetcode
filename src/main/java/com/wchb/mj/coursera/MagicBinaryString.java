package com.wchb.mj.coursera;

import java.util.HashMap;

/**
 * @date 11/3/18 2:51 PM
 */
public class MagicBinaryString {

    public String solution(String str) {
        if (str == null || str.length() <= 1) return str;
        HashMap<String, String> map = new HashMap();
        return dfs(map, str);
    }
    

    public static String dfs(HashMap<String, String> map, String str) {
        if (map.containsKey(str)) return map.get(str);
        String res = str;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                for (int k = j; k < str.length(); k++) {
                    if (j - i < 2 || k - j < 2 || (j - i) % 2 != 0 || (k - j) % 2 != 0) continue;
                    String pre = str.substring(i, j);
                    String post = str.substring(j, k);
                    if (isValid(pre) && isValid(post)) {
                        String after = str.substring(0, i) + post + pre + str.substring(k);
                        if (isLarger(after, str)) {
                            res = after;
                            String next = dfs(map, after);
                            if (isLarger(next, res)) {
                                res = next;
                            }
                        }
                    }
                }
            }
        }
        map.put(str, res);
        return res;
    }

    public static boolean isLarger(String after, String before) {
        for (int i = 0; i < after.length() && i < before.length(); i++) {
            if (after.charAt(i) != before.charAt(i)) return after.charAt(i) > before.charAt(i);
        }
        return after.length() > before.length();
    }

    public static boolean isValid(String a) {

        char[] arr = a.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') count++;
            if (count < i + 1 - count) return false;
        }
        return count == arr.length / 2;
    }

}
