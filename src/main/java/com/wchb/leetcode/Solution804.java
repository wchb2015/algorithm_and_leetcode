package com.wchb.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class Solution804 {

    private StringBuilder sb;

    private String[] morseArry = new String[]{
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {

        if (words.length == 0) {
            return 0;
        }

        Set<String> set = new TreeSet<>();

        for (String word : words) {
            sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morseArry[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
