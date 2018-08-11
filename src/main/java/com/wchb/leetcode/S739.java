package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 8/10/18 12:46 PM
 */
public class S739 {

    public int[] dailyTemperatures(int[] temperatures) {

        if (temperatures.length == 0) return temperatures;

        int[] ret = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            int curTemp = temperatures[i];

            int j = i + 1;

            while (j < temperatures.length) {
                if (temperatures[j] > curTemp) {
                    ret[i] = j - i;
                    break;
                }
                j++;
            }
            ret[i] = Math.max(ret[i], 0);
        }

        return ret;
    }

    /************************************************************/

    public int[] dailyTemperaturesV2(int[] T) {

        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);

            //System.out.println(i + " ---- " + stack);
        }
        return ans;
    }

}
