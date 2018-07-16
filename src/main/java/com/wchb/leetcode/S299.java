package com.wchb.leetcode;

/**
 * @date 7/15/18 9:44 PM
 */
public class S299 {
    public String getHint(String secret, String guess) {

        if (secret == null || secret.trim().length() == 0
                || guess == null || guess.trim().length() == 0) return null;

        int length = secret.length();

        int bulls = 0;
        int cows = 0;
        int[] arr = new int[10];
        char[] arr1 = secret.toCharArray();
        char[] arr2 = guess.toCharArray();

        for (int k = 0; k < length; k++) {
            if (arr1[k] == arr2[k]) {
                arr2[k] = 'a';
                bulls++;
            } else {
                arr[arr1[k] - '0']++;
            }
        }

        for (int k = 0; k < length; k++) {
            if (arr2[k] != 'a' && arr[arr2[k] - '0'] > 0) {
                arr[arr2[k] - '0']--;
                cows++;
            }
        }


        return bulls + "A" + cows + "B";
    }
}
