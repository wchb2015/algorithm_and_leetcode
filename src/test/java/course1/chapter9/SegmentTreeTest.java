package course1.chapter9;

import com.wchb.course1.chapter9.SegmentTree;
import org.junit.Test;

/**
 * @date 6/4/18 5:21 PM
 */
public class SegmentTreeTest {

    @Test
    public void test01() {
        Integer[] nums = new Integer[]{9, 2, 3, 4};

        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);

        System.out.println(segmentTree.query(0, 3));
        System.out.println(segmentTree);
    }

}
