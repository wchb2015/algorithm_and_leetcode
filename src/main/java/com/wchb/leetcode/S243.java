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

    /************************************************************/
    // For each a, we need to get the recent position of b.
    // For each b, we need to get the recent position of a.
    public int shortestDistanceV2(String[] words, String word1, String word2) {

        int res = Integer.MAX_VALUE;

        int index1 = -1, index2 = -1;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                if (index2 != -1) {
                    res = Math.min(res, i - index2);
                }
                index1 = i;
            } else if (word.equals(word2)) {
                if (index1 != -1) {
                    res = Math.min(res, i - index1);
                }
                index2 = i;
            }
        }
        return res;
    }

    /************************************************************/
    //binary search
    public int shortestDistanceV3(String[] words, String word1, String word2) {
        return 1;
    }
}
