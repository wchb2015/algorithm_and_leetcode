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

        SparseGraph g1 = new SparseGraph(7, false);
        new ReadGraph(g1, new int[][]{
                {0, 1}, {0, 2}, {0, 5},
                {0, 6}, {5, 3}, {5, 4}
                , {3, 4}, {4, 6}});
        System.out.println("test G2 in Sparse Graph:");
        g1.show();


        Path path = new Path(g1, 0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);
    }
}
