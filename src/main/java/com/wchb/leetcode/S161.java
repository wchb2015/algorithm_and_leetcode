package com.wchb.leetcode;


/**
 * @date 8/1/18 1:38 PM
 */
public class S161 {

    public boolean isOneEditDistance(String s, String t) {

        if (s.length() == t.length()) {
            return oneEditReplace(s, t);
        } else if (s.length() + 1 == t.length()) {
            return oneEditInsertOrRemove(s, t);
        } else if (s.length() - 1 == t.length()) {
            return oneEditInsertOrRemove(t, s);
        }

        return false;
    }

    private boolean oneEditReplace(String s, String t) {

        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) continue;
            diff++;
            if (diff > 2) return false;
        }

        return diff == 1;
    }

    private boolean oneEditInsertOrRemove(String s, String l) {
        int lenS = s.length();
        int lenL = l.length();

        if (lenS == 0) return true;

        for (int i = 0, j = 0; i < lenS && j < lenL; ) {
            if (s.charAt(i) == l.charAt(j)) {
                i++;
                j++;
            } else {
                if (i != j) {
                    return false;
                }

                j++;
            }
        }

        return true;
    }


}
