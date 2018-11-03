package com.wchb.mj.coursera;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 10/30/18 5:38 PM
 */
public class ReformattingDates {
    private static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("Jan", 1);
        map.put("Feb", 2);
        map.put("Mar", 3);
        map.put("Apr", 4);
        map.put("May", 5);
        map.put("Jun", 6);
        map.put("Jul", 7);
        map.put("Aug", 8);
        map.put("Sep", 9);
        map.put("Oct", 10);
        map.put("Nov", 11);
        map.put("Dec", 12);
    }


    public static String convert(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr[0].length(); i++) {
            if (Character.isDigit(arr[0].charAt(i))) {
                sb.append(arr[0].charAt(i));
            }
        }
        int day = Integer.parseInt(sb.toString());
        int mon = map.get(arr[1]);
        int year = Integer.parseInt(arr[2]);


        return year + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
    }


    public static void main(String[] args) {

        System.out.println(convert("1st Mar 1984"));

    }
}
