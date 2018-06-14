package com.wchb.course2.chapter7;

/**
 * @date 6/13/18 2:55 PM
 */

public class ReadGraph {

    public ReadGraph(IGraph graph, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j + 1 < edges[i].length; j++) {
                graph.addEdge(edges[i][j], edges[i][j + 1]);
            }
        }
    }

}

