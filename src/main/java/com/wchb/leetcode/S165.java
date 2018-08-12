package com.wchb.leetcode;

/**
 * @date 8/11/18 3:44 PM
 */
public class S165 {

    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        if (v1.length > v2.length) return -compareVersion(version2, version1);

        int i = 0;
        for (; i < v1.length; i++) {
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) return 1;
            if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) return -1;
        }

        for (int j = i; j < v2.length; j++) {
            if (Integer.parseInt(v2[j]) != 0) return -1;
        }

        return 0;
    }


}
