package com.wchb.leetcode;

import java.util.*;

/**
 * @date 6/11/18 4:45 PM
 */
public class S690 {

    Map<Integer, Employee> map = null;

    Map<Integer, Employee> emap;

    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e : employees) {
            emap.put(e.id, e);
        }
        return dfs(queryid);
    }

    private int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subId : employee.subordinates) {
            ans += dfs(subId);
        }
        return ans;
    }

    private class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }


    public void justRun() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, 5, Arrays.asList(2, 3)));
        list.add(new Employee(2, 3, Arrays.asList(4)));
        list.add(new Employee(3, 4, null));
        list.add(new Employee(4, 1, null));

//[[1,5,[2,3]],[2,3,[4]],[3,4,[]],[4,1,[]]]

        getImportance(list, 1);
    }

}
