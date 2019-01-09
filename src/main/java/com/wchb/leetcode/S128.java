package com.wchb.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @date 6/23/18 3:54 PM
 */
public class S128 {

    /************************************************************/

    public int longestConsecutive(int[] nums) {

        int ans = 0;

        Set<Integer> unvisited = new HashSet<>();
        for (int n : nums) unvisited.add(n);

        for (int n : nums) {

            if (unvisited.isEmpty()) {
                break;
            }

            if (!unvisited.contains(n)) {
                continue;
            }

            unvisited.remove(n);
            int len = 1;
            int leftOffset = -1;
            int rightOffset = 1;

            while (unvisited.remove(n + leftOffset)) {
                leftOffset--;
                len++;
            }

            while (unvisited.remove(n + rightOffset)) {
                rightOffset++;
                len++;
            }

            ans = Math.max(len, ans);

        }
        return ans;
    }

    /************************************************************/

    //并查集;
    public int longestConsecutiveV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        WeightedUnionFind uf = new WeightedUnionFind(nums);

        for (int num : nums) {
            uf.union(num, num - 1);
            uf.union(num, num + 1);
        }

        return uf.maxSize;
    }

    private class WeightedUnionFind {
        private HashMap<Integer, Integer> parent;
        private HashMap<Integer, Integer> size;
        private int maxSize;

        public WeightedUnionFind(int[] nums) {
            int N = nums.length;
            parent = new HashMap<>();
            size = new HashMap<>();
            maxSize = 1;

            for (int i = 0; i < N; i++) {
                parent.put(nums[i], nums[i]);
                size.put(nums[i], 1);
            }
        }

        // With path compression
        public Integer find(Integer num) {
            if (!parent.containsKey(num)) {
                return null;
            }

            Integer root = num;
            while (root != parent.get(root)) {
                root = parent.get(root);
            }
            while (num != root) {
                Integer next = parent.get(num);
                parent.put(num, root);
                num = next;
            }

            return root;
        }

        public void union(int p, int q) {
            Integer pRoot = find(p);
            Integer qRoot = find(q);

            if (pRoot == null || qRoot == null) {
                return;
            }
            if (pRoot == qRoot) {
                return;
            }

            int pSize = size.get(pRoot);
            int qSize = size.get(qRoot);


            if (pSize > qSize) {
                parent.put(qRoot, pRoot);
                size.put(pRoot, pSize + qSize);
                maxSize = Math.max(maxSize, pSize + qSize);
            } else {
                parent.put(pRoot, qRoot);
                size.put(qRoot, pSize + qSize);
                maxSize = Math.max(maxSize, pSize + qSize);
            }
        }

    }

    /************************************************************/

    //  滑动窗口
    public int longestConsecutiveV3(int[] nums) {
        Arrays.sort(nums);
        return findLength(nums);
    }

    public int findLength(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int ans = 1;
        int anchor = 0;

        int dup = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                dup++;
                continue;
            }
            if (nums[i] != (nums[i - 1] + 1)) {
                dup = 0;
                anchor = i;
            }

            ans = Math.max(ans, i - anchor + 1 - dup);
        }

        return ans;
    }

    /************************************************************/
    public int longestConsecutiveV4(int[] nums) {

        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) continue;
            Integer left = map.get(num - 1);
            Integer right = map.get(num + 1);

            int l = left == null ? 0 : left;
            int r = right == null ? 0 : right;

            int t = l + r + 1;
            map.put(num, t);
            map.put(num - l, t);
            map.put(num + r, t);

            ans = Math.max(ans, t);
        }

        return ans;

    }


}
