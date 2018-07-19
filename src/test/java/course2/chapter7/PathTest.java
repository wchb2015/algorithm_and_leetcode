package course2.chapter7;

import com.wchb.course2.chapter7.Path;
import com.wchb.course2.chapter7.ReadGraph;
import com.wchb.course2.chapter7.SparseGraph;
import org.junit.Test;

/**
 * @date 7/17/18 2:13 PM
 */
public class PathTest {

    @Test
    public void test01() {

        SparseGraph g1 = new SparseGraph(4, true);
        new ReadGraph(g1, new int[][]{
                {0, 1}, {0, 2}, {2, 3},
                {1, 3}});
        System.out.println("test g1 in Sparse Graph:");
        g1.show();

        Path path = new Path(g1, 0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(3);
    }
}
