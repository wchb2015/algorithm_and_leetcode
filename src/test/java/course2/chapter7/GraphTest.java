package course2.chapter7;

import com.wchb.course2.chapter7.*;
import org.junit.Test;

/**
 * @date 6/13/18 2:55 PM
 */
public class GraphTest {

    @Test
    public void test01() {
        // 使用两种图的存储方式读取testG1.txt文件
        SparseGraph g1 = new SparseGraph(13, false);
        new ReadGraph(g1, new int[][]{{0, 5}, {4, 3}, {0, 1},
                {9, 12}, {6, 4}, {5, 4},
                {0, 2}, {11, 12}, {9, 10},
                {0, 6}, {7, 8}, {9, 11},
                {5, 3}});
        System.out.println("test G1 in Sparse Graph:");
        g1.show();
        System.out.println(" 联通分量: " + new Components(g1).count());
        System.out.println("-------------------------------------");

        DenseGraph g2 = new DenseGraph(13, false);
        new ReadGraph(g2, new int[][]{{0, 5}, {4, 3}, {0, 1},
                {9, 12}, {6, 4}, {5, 4},
                {0, 2}, {11, 12}, {9, 10},
                {0, 6}, {7, 8}, {9, 11},
                {5, 3}});
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println("-------------------------------------");

        // 使用两种图的存储方式读取testG2.txt文件
        SparseGraph g3 = new SparseGraph(6, false);
        new ReadGraph(g3, new int[][]{
                {0, 1}, {0, 2}, {0, 5},
                {1, 2}, {1, 3}, {1, 4}
                , {3, 4}, {3, 5}});
        System.out.println("test G2 in Sparse Graph:");
        g3.show();
        System.out.println(" 联通分量: " + new Components(g3).count());


        System.out.println("-------------------------------------");

        DenseGraph g4 = new DenseGraph(6, false);
        new ReadGraph(g4, new int[][]{
                {0, 1}, {0, 2}, {0, 5},
                {1, 2}, {1, 3}, {1, 4}
                , {3, 4}, {3, 5}});
        System.out.println("test G2 in Dense Graph:");
        g4.show();

    }

    @Test
    // 测试无权图最短路径算法
    public void test03() {
        SparseGraph g = new SparseGraph(7, false);
        new ReadGraph(g, new int[][]{{0, 1}, {0, 2}, {0, 5},
                {0, 6}, {5, 3}, {5, 4}
                , {3, 4}, {4, 6}});
        g.show();

        ShortestPath bfs2 = new ShortestPath(g, 5);
        System.out.println("BFS : ");
        System.out.println("Has Path : " + bfs2.hasPath(2));
        bfs2.showPath(6);
    }

    @Test
    public void test02() {
        SparseGraph g1 = new SparseGraph(13, false);
        new ReadGraph(g1, new int[][]{{0, 5}, {4, 3}, {0, 1},
                {9, 12}, {6, 4}, {5, 4},
                {0, 2}, {11, 12}, {9, 10},
                {0, 6}, {7, 8}, {9, 11},
                {5, 3}});
        System.out.println("test G2 in Sparse Graph:");
        g1.show();
        System.out.println(new Components(g1).count());
        System.out.println(new Components(g1).isConnected(1, 8));
    }


}
