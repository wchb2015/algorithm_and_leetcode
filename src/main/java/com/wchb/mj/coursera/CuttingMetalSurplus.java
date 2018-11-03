package com.wchb.mj.coursera;

import java.util.Arrays;

/**
 * @date 11/2/18 10:27 AM
 */
public class CuttingMetalSurplus {

    public int solution(int curCost, int unitPrice, int[] lengths) {
        int n = lengths.length;
        Arrays.sort(lengths);
        int ans = 0;

        int max = lengths[n - 1];

        for (int i = max; i >= 1; i--) {
            int temp = helper(i, curCost, unitPrice, lengths);
            if (temp <= 0) {
                return ans > 0 ? ans : getNoCutProfit(curCost, unitPrice, lengths);
            }
            ans = Math.max(ans, temp);
        }


        return ans;
    }

    private int getNoCutProfit(int curCost, int unitPrice, int[] lengths) {
        int length = lengths[0];
        int totalUniformRods = 0;

        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] == length) {
                totalUniformRods++;
            } else {
                break;
            }
        }
        return totalUniformRods * unitPrice * length;
    }

    private int helper(int saleLength, int curCost, int unitPrice, int[] lengths) {
        int totalCuts = 0;
        int totalUniformRods = 0;


        //cal totalCuts
        //cal totalUniformRods
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] < saleLength) continue;

            totalCuts += lengths[i] / saleLength;
            totalUniformRods += lengths[i] / saleLength;

        }


        return totalUniformRods * saleLength * unitPrice - curCost * totalCuts;
    }

}
