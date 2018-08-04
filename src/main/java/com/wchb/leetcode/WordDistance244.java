package com.wchb.leetcode;

import java.util.LinkedList;

/**
 * @date 8/3/18 4:27 PM
 */
public class WordDistance244 {

    private String[] words;

    public WordDistance244(String[] words) {
        this.words = words;
    }

    public int shortest(String word1, String word2) {

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word2)) list2.add(i);
            if (words[i].equals(word1)) list1.add(i);
        }

        int min = words.length;

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
            }
        }


        return min;
    }
}
