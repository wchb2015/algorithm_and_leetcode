package course2.chapter4;

import com.wchb.course2.util.SortTestHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @date 6/2/18 3:34 PM
 */
public class MaxHeapSortTest {

    @Test
    public void test01() {
        System.out.println(Arrays.toString(SortTestHelper.generateRandomArray(100, 1, 10)));
    }

    @Test
    public void test02() {
        Integer[] arr = SortTestHelper.generateRandomArray(1000000, 1, Integer.MAX_VALUE);

        SortTestHelper.testSort("com.wchb.course2.chapter4.HeapSort1", arr);
        SortTestHelper.testSort("com.wchb.course2.chapter4.HeapSort2", arr);
        SortTestHelper.testSort("com.wchb.course2.chapter4.HeapSort3", arr);
    }
}
