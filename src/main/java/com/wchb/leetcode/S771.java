package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 6/5/18 11:01 AM
 */
public class S771 {


    @CreatedByMyself
    public int numJewelsInStones(String J, String S) {

        int ret = 0;

        char[] jArr = J.toCharArray();
        Set<Character> characterSet = new HashSet<>();

        for (char j : jArr) {
            characterSet.add(j);
        }

        for (char c : S.toCharArray()) {
            if (characterSet.contains(c)) {
                ret = ret + 1;
            }
        }

        return ret;
    }


}
