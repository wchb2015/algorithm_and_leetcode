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

    /************************************************************/

    Map<Integer, List<Integer>> g2;
    List<Integer> ans;

    public List<Integer> distanceKV2(TreeNode root, TreeNode target, int K) {
        g2 = new HashMap<>();
        ans = new LinkedList<>();

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.pop();

            g2.putIfAbsent(cur.val, new LinkedList<>());

            if (cur.left != null) {
                g2.get(cur.val).add(cur.left.val);
                g2.putIfAbsent(cur.left.val, new LinkedList<>());
                g2.get(cur.left.val).add(cur.val);
                q.add(cur.left);
            }
            if (cur.right != null) {
                g2.get(cur.val).add(cur.right.val);
                g2.putIfAbsent(cur.right.val, new LinkedList<>());
                g2.get(cur.right.val).add(cur.val);
                q.add(cur.right);
            }
        }

        //System.out.println(g);

        LinkedList<Integer> q2 = new LinkedList<>();
        q2.add(target.val);
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);

        int i = 0;

        while (!q2.isEmpty()) {

            int size = q2.size();
            if (i == K) ans.addAll(new ArrayList<>(q2));
            while (size > 0) {
                size--;
                Integer entry = q2.pop();

                if (g2.get(entry).size() > 0) {
                    for (Integer temp : g2.get(entry)) {
                        if (!visited.contains(temp)) q2.add(temp);
                        visited.add(temp);
                    }
                }
            }

            i++;
        }

        return ans;
    }

}
