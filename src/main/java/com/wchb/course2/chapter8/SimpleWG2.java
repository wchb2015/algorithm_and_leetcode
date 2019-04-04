package com.wchb.course2.chapter8;

import java.util.*;

/**
 * @date 3/13/19 3:11 PM
 */
public class SimpleWG2 {

    Map<Integer, Map<Integer, Double>> g;
    boolean[] visited;
    PriorityQueue<Edge> pq;
    List<Edge> mst;

    UF uf;

    public SimpleWG2(Edge[] arr, int V) {
        g = new HashMap<>();
        visited = new boolean[V];
        pq = new PriorityQueue<>((e1, e2) -> Double.compare(e1.weight, e2.weight));
        mst = new LinkedList<>();
        uf = new UF(V);

        for (Edge edge : arr) {
            if (!g.containsKey(edge.from)) g.put(edge.from, new HashMap<>());
            if (!g.containsKey(edge.to)) g.put(edge.to, new HashMap<>());
            g.get(edge.from).put(edge.to, edge.weight);
            g.get(edge.to).put(edge.from, edge.weight);
            pq.offer(edge);
        }

    }


    private void kruskal() {
        while (!pq.isEmpty()) {

            Edge e = pq.poll();

            if (uf.find(e.from) == uf.find(e.to)) {
                continue;
            }

            uf.union(e.from, e.to);
            mst.add(e);

        }

        System.out.println(mst);
        double ans = 0;
        for (Edge e : mst) {
            ans += e.weight;
        }
        System.out.println(ans);
    }


    static class Edge {
        int from;
        int to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }


    public static void main(String[] args) {
        SimpleWG2 wg = new SimpleWG2(new Edge[]{
                new Edge(0, 2, 0.26),
                new Edge(0, 4, 0.38),
                new Edge(0, 6, 0.58),
                new Edge(0, 7, 0.16),
                new Edge(1, 2, 0.36),
                new Edge(1, 3, 0.29),
                new Edge(1, 5, 0.32),
                new Edge(1, 7, 0.19),
                new Edge(2, 3, 0.17),
                new Edge(2, 6, 0.40),
                new Edge(2, 7, 0.34),
                new Edge(3, 6, 0.52),
                new Edge(4, 5, 0.35),
                new Edge(4, 6, 0.93),
                new Edge(4, 7, 0.37),
                new Edge(5, 7, 0.28)
        }, 8);


        wg.kruskal();
    }


    static class UF {

        int size;
        int[] arr;

        public UF(int size) {
            this.size = size;
            arr = new int[size];
            Arrays.fill(arr, -1);
        }

        public int size() {
            return size;
        }

        public void union(int v, int x) {

            if (find(v) == find(x)) return;

            int idOfV = find(v);
            int idOfX = find(x);


            for (int i = 0; i < arr.length; i++) {
                if (find(i) == idOfX) {
                    size--;
                    arr[i] = idOfV;
                }
            }

        }


        public int find(int v) {
            if (arr[v] == -1) return v;
            return arr[v];
        }
    }
}
