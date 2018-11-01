package com.wchb.leetcode;

import java.util.*;

/**
 * @date 10/31/18 2:43 PM
 */
public class SplittingPixels {

    String black = "000000000000000000000000";
    String white = "111111111111111111111111";
    String red = "111111110000000000000000";
    String green = "000000001111111100000000";
    String blue = "000000000000000011111111";

    Map<String, String> map = new HashMap<>();


    public String[] solution(List<String> colors) {

        List<String> sourceCol = new LinkedList<>();
        sourceCol.add(black);
        sourceCol.add(white);
        sourceCol.add(red);
        sourceCol.add(green);
        sourceCol.add(blue);
        map.put(black, "black");
        map.put(white, "white");
        map.put(red, "red");
        map.put(green, "green");
        map.put(blue, "blue");
        map.put("Ambiguous", "Ambiguous");

        String[] ans = new String[colors.size()];

        for (int i = 0; i < colors.size(); i++) {
            ans[i] = map.get(helper(colors.get(i), sourceCol));
        }

        return ans;
    }

    private String helper(String s1, List<String> sourceCol) {

        int dif = Integer.MAX_VALUE;
        String ans = "";

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < sourceCol.size(); i++) {
            int temp = getDif(s1, sourceCol.get(i));
            if (set.contains(temp)) return "Ambiguous";
            set.add(temp);
            if (temp < dif) {
                ans = sourceCol.get(i);
                dif = temp;
            }
        }

        return ans;
    }


    private int getDif(String s1, String s2) {

        int a1 = 0, a2 = 0, a3 = 0;

        a1 = Integer.parseInt(s1.substring(0, 8), 2) - Integer.parseInt(s2.substring(0, 8), 2);
        a2 = Integer.parseInt(s1.substring(8, 16), 2) - Integer.parseInt(s2.substring(8, 16), 2);
        a3 = Integer.parseInt(s1.substring(16), 2) - Integer.parseInt(s2.substring(16), 2);


        return a1 * a1 + a2 * a2 + a3 * a3;
    }


}
