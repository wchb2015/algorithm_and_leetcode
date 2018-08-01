package com.wchb.cc189.chapter1;

/**
 * @date 7/31/18 10:47 AM
 */
//Given two strings,write a method to decide if one is a permutation of the other.
public class CheckPermutation {
    public static boolean isPermutation(String s, String t) {

        // Permutations must be same length
        if (s.length() != t.length()) return false;

        int[] letters = new int[128];//Assumption: ASCII

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) return false;
        }

        //letters has no neg values, and therefore no pos values either
        return true;
    }


    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
