package course2.chapter7;

import com.wchb.course2.chapter7.DenseGraph;
import com.wchb.course2.chapter7.ReadGraph;
import com.wchb.course2.chapter7.SparseGraph;
import org.junit.Test;

/**
 * @date 6/13/18 2:55 PM
 */
public class GraphTest {

    @Test
    public void test02() {
        String filename = "./target/classes/testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        new ReadGraph(g1, filename);
        System.out.println("test G2 in Sparse Graph:");
        g1.show();

        System.out.println(new Components(g1).count());
        System.out.println(new Components(g1).isConnected(1, 8));
    }

    @Test
    public void test01() {

        // 使用两种图的存储方式读取testG1.txt文件
        String filename = "./target/classes/testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        new ReadGraph(g1, filename);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();

        System.out.println("-------------------------------------");

        DenseGraph g2 = new DenseGraph(13, false);
        new ReadGraph(g2, filename);
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println("-------------------------------------");

        // 使用两种图的存储方式读取testG2.txt文件
        filename = "./target/classes/testG2.txt";
        SparseGraph g3 = new SparseGraph(6, false);
        new ReadGraph(g3, filename);
        System.out.println("test G2 in Sparse Graph:");
        g3.show();


        System.out.println("-------------------------------------");

        DenseGraph g4 = new DenseGraph(6, false);
        new ReadGraph(g4, filename);
        System.out.println("test G2 in Dense Graph:");
        g4.show();

    }
}
