package com.wchb.leetcode;

/**
 * @date 10/3/18 11:40 AM
 */
public class S33 {

    // Use of Binary Search Algorithm
    int n;

    public int search(int[] nums, int target) {
        n = nums.length;

        if (n == 0) return -1;
        //1. Find index of pivot element (minimum element)
        //2. If num lies between start element and element at pivot-1 position,then find num
        //in array[start...pivot-1] using binary search
        //3. Else if num lies between pivot and last element, then find in array[pivot...end]

        int idx = findIndexOfPivotElement(nums);

        System.out.println(idx);
        if (idx == 0) return binarySearch(0, n - 1, nums, target);
        int left = binarySearch(0, idx - 1, nums, target);

        return left == -1 ? binarySearch(idx, n - 1, nums, target) : left;

    }

    private int binarySearch(int start, int end, int[] nums, int t) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == t) return mid;
            else if (nums[mid] > t) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    //1. if array[0]<=array[length of array -1],it means the array is not rotated,so return 0;
    //2. Initialize start = 0,end = length of array -1
    //3. Repeat following steps till start <= end
    //a) set mid = (start+end)/2;
    //b) if mid+1 is pivot , then break;
    //c) if array[start]<=array[mid],it means from start to mid,all elements are in sorted.
    //order. set start = mid+1, so that we look for pivot in second half of the array.
    //d) else if set end = mid-1, to look for pivot in first half

    //Node if arr[mid]> arr[mid+1], mid+1 is pivot


    private int findIndexOfPivotElement(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n - 1]) return 0;

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) return mid + 1;
            else if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
