package com.wchb.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 6/21/18 2:34 PM
 */
public class S46 {

    private static final Logger logger = LoggerFactory.getLogger(S46.class);

    List<List<Integer>> ret = new LinkedList<>();

    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        if (nums.length == 0) {
            return ret;
        }
        used = new boolean[nums.length];

        generatePermutation(nums, 0, new LinkedList<>());

        return ret;
    }

    // p中保存了一个有index-1个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> ints) {

        logger.info(" start index: {} , ints: {} ", index, ints);

        if (index == nums.length) {
            ret.add((LinkedList<Integer>) ints.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!used[i]) {
                used[i] = true;
                ints.add(nums[i]);
                generatePermutation(nums, index + 1, ints);
                ints.removeLast();
                used[i] = false;
            }
        }

        logger.info(" end index: {} , ints: {} ", index, ints);
    }

}


//
//    //s中保存了此时从digits[0.....index-1]翻译得到的一个字母字符串
//    //寻找和digits[index]匹配的字母,获得digits[0...index]翻译得到的解
//    private void findCombination(String digits, int index, String s) {
//
//        System.out.println(index + " : " + s);
//
//        if (index == digits.length()) {
//            ret.add(s);
//            System.out.println("get " + s + " , return");
//            return;
//        }
//
//        char c = digits.charAt(index);
//
//        assert (c >= '0' && c <= '9' && c != '1');
//
//        String letters = letterMap[c - '0'];
//
//        for (int i = 0; i < letters.length(); i++) {
//            System.out.println("digits[" + index + "] = " + c +
//                    " , use " + letters.charAt(i));
//            findCombination(digits, index + 1, s + letters.charAt(i));
//        }
//
//        System.out.println("digits[" + index + "] = " + c + " complete, return");
//
//    }
