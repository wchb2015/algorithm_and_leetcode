package course2.chapter4;

import com.wchb.course2.util.SortHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @date 6/2/18 3:34 PM
 */
public class MaxHeapSortTest {

    @Test
    public void test01() {
        System.out.println(Arrays.toString(SortHelper.generateRandomArray(100, 1, 10)));
    }

    @Test
    public void test02() {
        Integer[] arr = SortHelper.generateRandomArray(1000000, 1, Integer.MAX_VALUE);

        SortHelper.testSort("com.wchb.course2.chapter4.HeapSort1", arr);
        SortHelper.testSort("com.wchb.course2.chapter4.HeapSort2", arr);
        SortHelper.testSort("com.wchb.course2.chapter4.HeapSort3", arr);
    }
}
