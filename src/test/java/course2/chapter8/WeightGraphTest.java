package course2.chapter8;

import com.wchb.course2.chapter8.ReadWeightGraph;
import com.wchb.course2.chapter8.DenseWeightedGraph;
import com.wchb.course2.chapter8.SparseWeightedGraph;
import org.junit.Test;

/**
 * @date 6/14/18 10:44 AM
 */
public class WeightGraphTest {

    @Test
    public void test01() {

        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<>(8, false);
        new ReadWeightGraph(g1, new double[][]{
                {4, 5, 0.35}, {4, 7, 0.37}, {5, 7, 0.28},
                {0, 7, 0.16}, {1, 5, 0.32}, {0, 4, 0.38},
                {2, 3, 0.17}, {1, 7, 0.19}, {0, 2, 0.26},
                {1, 2, 0.36}, {1, 3, 0.29}, {2, 7, 0.34},
                {6, 2, 0.40}, {3, 6, 0.52}, {6, 0, 0.58},
                {6, 4, 0.93}
        });
        System.out.println("test G1 in Sparse Weighted Graph:");
        g1.show();

        System.out.println("---------------");

        DenseWeightedGraph<Double> g2 = new DenseWeightedGraph<>(8, false);
        new ReadWeightGraph(g2, new double[][]{
                {4, 5, 0.35}, {4, 7, 0.37}, {5, 7, 0.28},
                {0, 7, 0.16}, {1, 5, 0.32}, {0, 4, 0.38},
                {2, 3, 0.17}, {1, 7, 0.19}, {0, 2, 0.26},
                {1, 2, 0.36}, {1, 3, 0.29}, {2, 7, 0.34},
                {6, 2, 0.40}, {3, 6, 0.52}, {6, 0, 0.58},
                {6, 4, 0.93}
        });
        System.out.println("test G1 in Dense Graph:");
        g2.show();

    }
}
