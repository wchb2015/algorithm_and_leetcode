package com.wchb.mj.coursera;

import java.util.Arrays;

/**
 * @date 11/2/18 9:07 AM
 */
public class Triplets {

    public int solution(int[] arr, int threshold) {
        int ans = 0;

        int n = arr.length;
        if (n < 3) return ans;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] <= threshold) {
                        System.out.println(arr[i] + "--" + arr[j] + "--" + arr[k]);
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
