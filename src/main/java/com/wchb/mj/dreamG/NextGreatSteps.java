package com.wchb.mj.dreamG;

import java.util.Arrays;
import java.util.Stack;

/**
 * @date 12/26/18 1:26 PM
 */
// 给一个数组,返回一个大小相同的数组.返回的数组的第i个位置的值应当是,对于原数组中的第i个元素,至少往右走多少步,
// 才能遇到一个比自己大的元素(如果之后没有比自己大的元素,或者已经是最后一个元素,则在返回数组的对应位置放上-1)(Google)(单调栈)(Github)
// Eg: input: 5,3,1,2,4 return: -1 3 1 1 -1
public class NextGreatSteps {
    public int[] solution(int[] input) {
        int[] ans = new int[input.length];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
