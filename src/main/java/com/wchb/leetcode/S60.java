package com.wchb.leetcode;


/**
 * @date 8/2/18 3:32 PM
 */
public class S60 {

    boolean[] used;
    int i = 0;
    String ret;

    public String getPermutation(int n, int k) {

        int[] nums = new int[n + 1];
        used = new boolean[n + 1];

        for (int i = 1; i <= n; i++) nums[i] = i;

        dfs(nums, new StringBuilder(k), n, k);

        return ret;

    }

    private void dfs(int[] nums, StringBuilder path, int n, int k) {

        if (path.length() == n) {
            i++;
            if (i == k) ret = path.toString();
            return;
        }

        for (int i : nums) {
            if (used[i] || i == 0) continue;
            used[i] = true;
            path.append(i);
            dfs(nums, path, n, k);
            path.setLength(path.length() - 1);
            used[i] = false;
        }
    }
}
