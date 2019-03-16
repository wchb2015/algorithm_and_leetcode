package com.wchb.mj.dreamA;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @date 3/14/19 9:51 AM
 */
public class PriorityQueueTest {


    public void testPQ() {

        //PriorityQueue<Student> pq = new PriorityQueue<>((s1, s2) -> s1.id.equals(s2.id) ?
        //        s1.name.compareTo(s2.name) : s1.id.compareTo(s2.id));


        Comparator com = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.id.equals(o2.id)) return o1.name.compareTo(o2.name);
                return o1.id.compareTo(o2.id);
            }
        };

        PriorityQueue<Student> pq = new PriorityQueue<>(com);


        pq.offer(new Student("a1", "zd"));
        pq.offer(new Student("a1", "bc"));

        pq.offer(new Student("z1", "a"));
        pq.offer(new Student("c1", "d"));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }


    public static void main(String[] args) {

        Map<Tester, Integer> map = new HashMap<>();

        map.put(new Tester(1), 1);
        map.put(new Tester(2), 1);

        System.out.println(map.size());
    }

    class Student {

        String id;
        String name;

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}' + System.lineSeparator();
        }
    }


    static class Tester {
        int val;

        public Tester(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            System.out.println("A");
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tester tester = (Tester) o;

            return val == tester.val;
        }

        @Override
        public int hashCode() {
            System.out.println("B");
            return 1;
        }
    }
}
