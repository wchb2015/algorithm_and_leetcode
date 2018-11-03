package com.wchb.mj.coursera;

/**
 * @date 11/2/18 7:43 AM
 */
public class PackingMelons {


    int n;

    public int solution(int[] melons, int[] boxes) {

        n = boxes.length;
        int maxMelons = 0;

        for (int i = 0; i < melons.length; i++) {
            for (int j = 0; j < boxes.length; j++) {
                int temp = helper(melons, boxes, i, j);
                maxMelons = Math.max(temp, maxMelons);
            }
        }

        return maxMelons;
    }

    private int helper(int[] melons, int[] boxes, int i, int j) {

        int ans = 0;

        while (i < melons.length && j < boxes.length) {
            if (boxes[j] >= melons[i]) {
                j++;
                i++;
                ans++;
            } else if (j + 1 < boxes.length && boxes[j + 1] >= melons[i]) {
                j += 2;
                i++;
                ans++;
            } else {
                j++;
            }
        }

        return ans;
    }


}
