package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 8/23/18 7:17 AM
 */
public class S84 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }


    /************************************************************/
    public int largestRectangleAreaV2(int[] heights) {
        int maxArea = 0;
        if (heights == null || heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                if (stack.isEmpty()) {
                    System.out.println("hahaha");
                }
                int start = stack.isEmpty() ? -1 : stack.peek();
                int width = i - start - 1;
                int area = height * width;
                System.out.println(" height: " + height + " width: " + width + " area: " + area);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
