package com.wchb.leetcode;

import java.util.List;
import java.util.Set;

/**
 * @date 6/11/18 4:45 PM
 */
public class S690 {

    public int getImportance(List<Employee> employees, int id) {
        int ret = 0;

        Employee employee = null;
        for (Employee e : employees) {
            if (e.id == id) {
                employee = e;
            }
        }

        if (employee != null) {
            ret += employee.importance;
            for (Employee e : employees) {
                if (employee.subordinates.contains(e.id)) {
                    ret += e.importance;
                }
            }
        }
        return ret;
    }


    private class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }


}
