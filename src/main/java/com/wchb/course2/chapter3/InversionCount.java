package com.wchb.course2.chapter3;

import java.util.Arrays;

/**
 * @date 7/3/18 2:36 PM
 */
public class InversionCount {

    private InversionCount() {
    }

    // 求arr[l..r]范围的逆序数对个数
    // 思考: 归并排序的优化可否用于求逆序数对的算法? :)
    private static int solution(int[] arr, int l, int r) {

        if (l >= r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        // 求出 arr[l...mid] 范围的逆序数
        int res1 = solution(arr, l, mid);
        // 求出 arr[mid+1...r] 范围的逆序数
        int res2 = solution(arr, mid + 1, r);

        return res1 + res2 + merge(arr, l, mid, r);

    }

    private static int merge(int[] arr, int l, int mid, int r) {

        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化逆序数对个数 ret = 0
        int ret = 0;
        // 初始化,i指向左半部分的起始索引位置l;j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] > aux[j - l]) {

                System.out.println(aux[i - l] + " ==== " + aux[j - l]);

                // 左半部分所指元素 > 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
                // 此时,因为右半部分k所指的元素小
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - j + 1
                ret += mid - i + 1;
            } else {
                // 左半部分所指元素 <= 右半部分所指元素
                arr[k] = aux[i - l];
                i++;

            }
        }

        return ret;
    }

    public static int solution(int[] arr) {
        int n = arr.length;
        return solution(arr, 0, n - 1);
    }


    public static void main(String[] args) {

        int[] arr = new int[]{2, 4, 3, 5, 1};
        System.out.println(solution(arr));

    }
}
