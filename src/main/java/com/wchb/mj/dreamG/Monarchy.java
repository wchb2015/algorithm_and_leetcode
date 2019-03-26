package com.wchb.mj.dreamG;

import java.util.*;

/**
 * @date 3/23/19 9:32 PM
 */
public class Monarchy {


    Set<String> deadSet;
    Map<String, LinkedList<String>> g;

    public Monarchy() {
        deadSet = new HashSet<>();
        g = new HashMap<>();
    }

    public void birth(String child_name, String parent) {
        if (!g.containsKey(parent)) g.put(parent, new LinkedList<>());
        g.get(parent).add(child_name);
    }

    public void death(String name) {
        deadSet.add(name);
    }

    public List<String> getOrderOfSuccession() {

        List<String> ans = new LinkedList<>();

        dfs("root_king", ans);

        return ans;
    }

    private void dfs(String v, List<String> ans) {
        ans.add(v);

        if (g.get(v) == null || g.get(v).size() == 0) return;

        for (String child : g.get(v)) {
            dfs(child, ans);
        }

    }
}
