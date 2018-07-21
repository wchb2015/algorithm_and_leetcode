package com.wchb.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @date 7/13/18 2:11 PM
 */
public class S78 {

    private static final Logger logger = LoggerFactory.getLogger(S78.class);


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //Arrays.sort(nums);
        getSubsets(result, new ArrayList<>(), nums, 0);


        System.out.println("result: " + result);
        return result;
    }

    private void getSubsets(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {

        int trackId = new Random().nextInt(10000);

        logger.info("trackId:{} START result: {}, list: {}, index:{}", trackId, result, list, start);

        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            getSubsets(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }

        logger.info("trackId:{}  END result: {}, list: {}, index:{}", trackId, result, list, start);

    }
}
