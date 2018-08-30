package com.wchb.leetcode;


import java.util.ArrayList;

/**
 * @date 8/2/18 3:32 PM
 */
public class S60 {

    public String getPermutation(int n, int k) {

        ArrayList<Integer> num = new ArrayList<>();
        int factor = 1;
        for (int i = 1; i < n; i++) {
            num.add(i);
            factor *= i;
        }

        StringBuilder sb = new StringBuilder();
        while (n > 1) {
            int ind = (k - 1) / (factor);
            sb.append(num.get(ind));
            num.remove(ind);
            n--;
            k = (k - 1) % factor + 1;
            factor = factor / n;
        }
        sb.append(num.get(0));
        return sb.toString();

    }

}
