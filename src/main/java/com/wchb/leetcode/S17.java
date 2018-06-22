package com.wchb.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 6/21/18 12:56 PM
 */
public class S17 {

    private static final Logger logger = LoggerFactory.getLogger(S17.class);

    List<String> ret = new ArrayList<>();

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.trim().length() == 0) {
            return ret;
        }

        findCombination(digits, 0, "");
        return ret;
    }


    //s中保存了此时从digits[0.....index-1]翻译得到的一个字母字符串
    //寻找和digits[index]匹配的字母,获得digits[0...index]翻译得到的解
    private void findCombination(String digits, int index, String s) {

        System.out.println(index + " : " + s);

        if (index == digits.length()) {
            ret.add(s);
            System.out.println("get " + s + " , return");
            return;
        }

        char c = digits.charAt(index);

        assert (c >= '0' && c <= '9' && c != '1');

        String letters = letterMap[c - '0'];

        for (int i = 0; i < letters.length(); i++) {
            System.out.println("digits[" + index + "] = " + c +
                    " , use " + letters.charAt(i));
            findCombination(digits, index + 1, s + letters.charAt(i));
        }

        System.out.println("digits[" + index + "] = " + c + " complete, return");

    }
}
