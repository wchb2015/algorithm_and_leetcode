package com.wchb.leetcode;

/**
 * @date 8/10/18 1:49 PM
 */
public class S29 {

    //T log(n)
    //S log(n)
    public int divide(int dividend, int divisor) {

        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) sign = -1;

        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        if (lDividend < lDivisor || lDividend == 0) return 0;

        long lres = divide(lDividend, lDivisor);
        int res;

        if (lres > Integer.MAX_VALUE) {
            res = (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
        } else {
            res = sign * (int) lres;
        }

        return res;
    }

    private long divide(long lDividend, long lDivisor) {

        if (lDividend < lDivisor) return 0;
        long sum = lDivisor;
        long multiple = 1;

        while ((sum + sum) <= lDividend) {
            sum += sum;
            multiple += multiple;
        }

        return multiple + divide(lDividend - sum, lDivisor);
    }
}
