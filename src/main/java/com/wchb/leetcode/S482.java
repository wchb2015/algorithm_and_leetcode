package com.wchb.leetcode;

import java.util.LinkedList;

/**
 * @date 8/24/18 3:18 PM
 */
public class S482 {
    public String licenseKeyFormatting(String s, int k) {

        if (s == null) return s;
        StringBuilder sb = new StringBuilder();

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') continue;
            list.add(s.charAt(i));
        }

        int firstLength = list.size() % k;

        if (list.size() == 0) return "";
        String temp = "";
        while (!list.isEmpty()) {
            if (firstLength > 0) {
                sb.append(Character.toUpperCase(list.remove()));
                firstLength--;
                if (firstLength == 0) sb.append("-");
            } else {
                temp += list.remove();
                if (temp.length() == k) {
                    sb.append(temp.toUpperCase()).append("-");
                    temp = "";
                }
            }
        }


        return sb.toString().substring(0, sb.length() - 1);


    }
}
