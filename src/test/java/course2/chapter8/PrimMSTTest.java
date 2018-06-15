package course2.chapter8;

import com.wchb.course2.chapter8.Edge;
import com.wchb.course2.chapter8.LazyPrimMST;
import com.wchb.course2.chapter8.ReadWeightGraph;
import com.wchb.course2.chapter8.SparseWeightedGraph;
import org.junit.Test;

import java.util.List;

/**
 * @date 6/14/18 2:08 PM
 */
public class PrimMSTTest {

    @Test
    public void test01() {

        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, false);
        new ReadWeightGraph(g, new double[][]{
                {4, 5, 0.35}, {4, 7, 0.37}, {5, 7, 0.28},
                {0, 7, 0.16}, {1, 5, 0.32}, {0, 4, 0.38},
                {2, 3, 0.17}, {1, 7, 0.19}, {0, 2, 0.26},
                {1, 2, 0.36}, {1, 3, 0.29}, {2, 7, 0.34},
                {6, 2, 0.40}, {3, 6, 0.52}, {6, 0, 0.58},
                {6, 4, 0.93}
        });

        g.show();
        System.out.println("--------");

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        List<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i));
        }
        System.out.println("The MST weight is: " + lazyPrimMST.result());

    }
}
