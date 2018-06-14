package com.wchb.course2.chapter8;

/**
 * @date 6/14/18 10:46 AM
 */
public class ReadWeightGraph {

    public ReadWeightGraph(IWeightedGraph graph, double[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j + 2 < edges[i].length; j++) {
                graph.addEdge(new Edge(
                        (int) edges[i][j],
                        (int) edges[i][j + 1],
                        edges[i][j + 2]));
            }
        }
    }
}
