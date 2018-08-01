package com.wchb.cc189.chapter1;

/**
 * @date 7/2/18 9:07 PM
 */
//Is Unique: Implement an algorithm to determine if a string has all unique characters.
//What if you cannot use additional data structures?
public class IsUnique {

    public static boolean isUniqueChars(String str) {
        if (str == null || str.trim().length() <= 1) return true;
        if (str.length() > 128) return false;
        boolean[] arr = new boolean[128];

        for (char c : str.toCharArray()) {
            if (arr[c] == true) return false;
            arr[c] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueChars("abc"));
        System.out.println(isUniqueChars("kite"));
        System.out.println(isUniqueChars("kitek"));
    }
}
