package com.wchb.leetcode;

/**
 * @date 7/22/18 10:02 PM
 */
public class S12 {


    public String intToRoman(int num) {
        if (num < 1) return "";

        StringBuilder res = new StringBuilder();
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


        for (int i = 0; i < numbers.length; i++) {
            while (num >= numbers[i]) {
                num -= numbers[i];
                res.append(roman[i]);
            }
        }

        return res.toString();
    }
}
