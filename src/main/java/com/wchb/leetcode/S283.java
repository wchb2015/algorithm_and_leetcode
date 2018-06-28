package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 6/14/18 1:05 PM
 */
public class S283 {

    // Solution: 把 零元素的 index放入优先队列.
    public void moveZeroesV1(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            System.out.println("start : " + queue);

            if (nums[i] == 0) {
                queue.add(i);
            } else if (queue.isEmpty()) {
                continue;
            } else {
                int key = Integer.parseInt(queue.remove().toString());
                nums[key] = nums[i];
                nums[i] = 0;
                queue.add(i);
            }

            System.out.println("End : " + queue);
        }
    }

    /************************************************************/

    //Time:O(n)  Space: O(1)
    //将非零元素取出,然后其余位置补零
    public void moveZeroesV2(int[] nums) {
        //指向下一个非零元素应该放的位置
        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                nums[pointer] = nums[i];
                pointer++;
            }
        }

        //补零
        for (; pointer < nums.length; pointer++) {
            nums[pointer] = 0;
        }
    }

}
