package com.wchb.leetcode;

/*      map.put("IV", 4); //normal - 2
        map.put("XL", 40);// normal - 20
        map.put("CD", 400);// normal - 200
        map.put("IX", 9);// normal - 2
        map.put("XC", 90);// normal - 20
        map.put("CM", 900);// normal - 200

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L ", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);*/

/**
 * @date 6/3/18 11:22 PM
 */
public class Solution13 {

    public int romanToInt(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int sum = 0;
        if (s.indexOf("IV") != -1) {
            sum -= 2;
        }
        if (s.indexOf("IX") != -1) {
            sum -= 2;
        }
        if (s.indexOf("XL") != -1) {
            sum -= 20;
        }
        if (s.indexOf("XC") != -1) {
            sum -= 20;
        }
        if (s.indexOf("CD") != -1) {
            sum -= 200;
        }
        if (s.indexOf("CM") != -1) {
            sum -= 200;
        }

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'I') {
                sum += 1;
            }
            if (charArray[i] == 'V') {
                sum += 5;
            }
            if (charArray[i] == 'X') {
                sum += 10;
            }
            if (charArray[i] == 'L') {
                sum += 50;
            }
            if (charArray[i] == 'C') {
                sum += 100;
            }
            if (charArray[i] == 'D') {
                sum += 500;
            }
            if (charArray[i] == 'M') {
                sum += 1000;
            }
        }

        return sum;
    }
}
