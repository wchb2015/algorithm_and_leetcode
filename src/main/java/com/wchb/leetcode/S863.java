package com.wchb.leetcode;

import java.util.*;

/**
 * @date 8/22/18 3:51 PM
 */
public class S863 {

    // Use DFS to build the graph, and use BFS to find all the nodes that are exact K steps from target.
    // Time complexity: O(n)
    // Space complexity: O(n)

    private Map<TreeNode, LinkedList<TreeNode>> g;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        g = new HashMap<>();
        buildGraph(null, root);


        List<Integer> ans = new LinkedList<>();

        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        seen.add(target);
        q.add(target);
        int j = 0;
        while (!q.isEmpty() && j <= K) {

            int s = q.size();
            while (s > 0) {
                s--;
                TreeNode cur = q.remove();

                if (j == K) ans.add(cur.val);

                if (g.get(cur) == null) System.out.println(cur.val);
                for (TreeNode adj : g.get(cur)) {
                    if (seen.contains(adj)) continue;
                    q.add(adj);
                    seen.add(adj);
                }
            }

            j++;
        }


        return ans;
    }

    private void buildGraph(TreeNode parent, TreeNode children) {

        if (parent != null) {
            if (g.get(parent) == null) g.put(parent, new LinkedList<>());
            g.get(parent).add(children);

            if (g.get(children) == null) g.put(children, new LinkedList<>());
            g.get(children).add(parent);
        }

        if (children.left != null) buildGraph(children, children.left);
        if (children.right != null) buildGraph(children, children.right);
    }
}
