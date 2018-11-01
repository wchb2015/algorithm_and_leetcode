package com.wchb.leetcode;

/**
 * @date 10/31/18 1:08 PM
 */
public class S800 {


    //http://www.cnblogs.com/grandyang/p/9296602.html


    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder(color.length());
        sb.append("#");
        sb.append(getHexDigits(color.substring(1, 3)));
        sb.append(getHexDigits(color.substring(3, 5)));
        sb.append(getHexDigits(color.substring(5)));
        return sb.toString();
    }

    private String getHexDigits(String s) {


        int sum = Integer.parseInt(s, 16);
        int index = sum / 17; // [ 0x00(0) , 0x11(17), 0x22(34),  0x33(51), ........., 0xff(255) ]
        int remainder = sum % 17;
        if (remainder > 17 / 2) {
            index++;
        }

        char c = (0 <= index && index <= 9) ? (char) ('0' + index) : (char) ('a' + index - 10);
        return String.valueOf(c) + String.valueOf(c);
    }
}

