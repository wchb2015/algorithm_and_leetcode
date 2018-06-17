package com.wchb.leetcode;

import java.util.PriorityQueue;

/**
 * @date 6/14/18 1:05 PM
 */
public class S283 {
    public void moveZeroesV1(int[] nums) {
        PriorityQueue queue = new PriorityQueue();
        for (int i = 0; i < nums.length; ++i) {
            System.out.println("start : " + queue);
            if (nums[i] == 0) {
                queue.add(i);
            } else if (!queue.isEmpty()) {
                int key = Integer.parseInt(queue.remove().toString());
                nums[key] = nums[i];
                nums[i] = 0;
                queue.add(i);
            }
            System.out.println("end : " + queue);
        }
    }

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
        for (int j = pointer; pointer < nums.length; pointer++) {
            nums[pointer] = 0;
        }
    }

    public void moveZeroesV3(int[] nums) {
        //指向下一个非零元素应该放的位置
        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                if (pointer != i) {
                    swap(nums, pointer, i);
                }
                pointer++;
            }
        }
    }

    private void swap(int[] nums, int i, int k) {
        assert i >= 0 && i < nums.length;
        assert k >= 0 && k < nums.length;

        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
}
