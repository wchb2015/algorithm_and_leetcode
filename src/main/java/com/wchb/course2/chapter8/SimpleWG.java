package com.wchb.course2.chapter8;

import java.util.*;

/**
 * @date 3/13/19 1:28 PM
 */
public class SimpleWG {

    Map<Integer, Map<Integer, Double>> g;
    boolean[] visited;
    PriorityQueue<Edge> pq;
    List<Edge> mst;

    public SimpleWG(Edge[] arr, int V) {
        g = new HashMap<>();
        visited = new boolean[V];
        pq = new PriorityQueue<>((e1, e2) -> Double.compare(e1.weight, e2.weight));
        mst = new LinkedList<>();

        for (Edge edge : arr) {
            if (!g.containsKey(edge.from)) g.put(edge.from, new HashMap<>());
            if (!g.containsKey(edge.to)) g.put(edge.to, new HashMap<>());
            g.get(edge.from).put(edge.to, edge.weight);
            g.get(edge.to).put(edge.from, edge.weight);
        }

    }

    private void visit(int v) {
        if (visited[v]) {
            System.out.println("hehe");
        }
        visited[v] = true;
        // 将和节点v相连接的所有未访问的边放入最小堆中
        for (Map.Entry<Integer, Double> nei : g.get(v).entrySet()) {
            if (!visited[nei.getKey()]) {
                pq.offer(new Edge(v, nei.getKey(), nei.getValue()));
            }
        }
    }


    private void lazyPrime() {

        visit(6);

        while (!pq.isEmpty()) {
            // 使用最小堆 找出已经访问的边中权值最小的边
            Edge minEdge = pq.poll();
            // 如果这条边的两边都访问过了,扔掉这条边
            if (visited[minEdge.from] && visited[minEdge.to]) continue;
            // 否则这条边应该在MST中
            mst.add(minEdge);

            // 访问和这条边相连的还没有被访问的节点
            if (!visited[minEdge.from]) {
                visit(minEdge.from);
            } else {
                visit(minEdge.to);
            }

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

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}' + System.lineSeparator();
        }
    }


    public static void main(String[] args) {
        SimpleWG wg = new SimpleWG(new Edge[]{
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


        wg.lazyPrime();
    }


}
