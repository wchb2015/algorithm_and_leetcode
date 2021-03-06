package com.wchb.course2.chapter3;

import com.wchb.course2.util.SortHelper;

/**
 * @date 7/3/18 2:37 PM
 */
public class SelectionKTH {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(SelectionKTH.solution(arr, 2));
    }

    // 寻找nums数组中第k小的元素
    // 注意: 在我们的算法中, k是从0开始索引的, 即最小的元素是第0小元素, 以此类推
    // 如果希望我们的算法中k的语意是从1开始的, 只需要在整个逻辑开始进行k--即可, 可以参考solve2
    public static int solution(int[] nums, int k) {
        assert nums != null && k >= 0 && k < nums.length;
        return solution(nums, 0, nums.length - 1, k);
    }

    // 求出nums[l...r]范围里第k小的数
    private static int solution(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }

        // partition之后, nums[p]的正确位置就在索引p上
        int p = partition(nums, l, r);

        if (k == p) {
            // 如果 k == p, 直接返回nums[p]
            return nums[p];
        } else if (k < p) {
            // 如果 k < p, 只需要在nums[l...p-1]中找第k小元素即可
            return solution(nums, l, p - 1, k);
        } else {
            // 如果 k > p, 则需要在nums[p+1...r]中找第k-p-1小元素
            // 注意: 由于我们传入__selection的依然是nums, 而不是nums[p+1...r],
            //       所以传入的最后一个参数依然是k, 而不是k-p-1
            return solution(nums, p + 1, r, k);
        }
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    // partition 过程, 和快排的partition一样
    // 思考: 双路快排和三路快排的思想能不能用在selection算法中? :)
    private static int partition(int[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        SortHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                SortHelper.swap(arr, j, i);
            }
        }


        SortHelper.swap(arr, l, j);

        return j;
    }

    private SelectionKTH() {
    }


}
