package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/22/18 9:26 PM
 */
public class S401 {
    List<String> ret;

    public List<String> readBinaryWatch(int num) {
        ret = new LinkedList<>();

        dfs(10, num, 0, "");

        return ret;
    }

    private void dfs(int num, int numOfOn, int index, String path) {

        if (numOfOn == 0 && index == num) {
            ret.add(path);
        }

        dfs(num, numOfOn - 1, index + 1, path);

    }
}
