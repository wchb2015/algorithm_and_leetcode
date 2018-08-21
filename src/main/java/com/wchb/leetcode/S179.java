package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 8/20/18 5:01 PM
 */
public class S179 {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) return "";

        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[num.length];
        for (int i = 0; i < num.length; i++)
            s_num[i] = String.valueOf(num[i]);
        // Comparator to decide which string should come first in concatenation

        Arrays.sort(s_num, (s1, s2) -> {
            String a = s1 + s2;
            String b = s2 + s1;
            return b.compareTo(a);
        });

        System.out.println(s_num);

        if (s_num[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : s_num) sb.append(s);
        return sb.toString();
    }

}
