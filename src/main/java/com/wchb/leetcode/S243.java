package com.wchb.leetcode;


import java.util.LinkedList;

/**
 * @date 8/3/18 3:51 PM
 */
public class S243 {
    public int shortestDistance(String[] words, String word1, String word2) {

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) list1.add(i);
            if (words[i].equals(word2)) list2.add(i);
        }


        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
            }
        }


        return min;
    }
}
