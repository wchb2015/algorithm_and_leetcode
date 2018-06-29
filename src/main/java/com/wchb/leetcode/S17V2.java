package com.wchb.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 6/28/18 5:33 PM
 */
public class S17V2 {

    private static final Logger logger = LoggerFactory.getLogger(S17V2.class);

    List<String> ret = new LinkedList<>();


    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        combination("", digits, 0);

        System.out.println("  ret: " + ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset) {

        logger.info(" prefix:{}  offset:{}", prefix, offset);
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1);
        }
    }


}
