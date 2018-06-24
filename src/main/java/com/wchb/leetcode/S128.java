package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * @date 6/23/18 3:54 PM
 */
public class S128 {

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

    public int longestConsecutive(int[] nums) {

        int ret = 0;

        Set<Integer> unvisited = getSet(nums);

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

            while (unvisited.remove(n + leftOffset--)) {
                len++;
            }

            while (unvisited.remove(n + rightOffset++)) {
                len++;
            }

            ret = Math.max(len, ret);

        }
        return ret;
    }


    private Set<Integer> getSet(int[] nums) {

        Set<Integer> set = new TreeSet<>();

        for (int n : nums) {
            set.add(n);
        }

        return set;
    }
}
