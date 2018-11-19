package com.wchb.leetcode;

/**
 * @date 8/1/18 3:17 PM
 */
public class S443 {
    public int compress(char[] chars) {

        int count = 1;
        int ans = 0;
        int n = chars.length;
        if (n == 1) return 1;

        for (int i = 1; i <= n; i++) {
            if (i == n || chars[i] != chars[i - 1]) {
                //Found new characters so write the count   of previous character
                chars[ans++] = chars[i - 1];
                if (count > 1) {
                    for (int k = 0; k < String.valueOf(count).length(); k++) {
                        chars[ans++] = String.valueOf(count).charAt(k);
                    }
                }

                count = 1;
            } else {
                //chars[i]==chars[i-1]
                count++;

            }
        }


        return ans;
    }
}
