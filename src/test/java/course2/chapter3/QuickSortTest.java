package course2.chapter3;

import com.wchb.course2.chapter3.QuickSort2;
import com.wchb.course2.util.SortHelper;
import org.junit.Test;

/**
 * @date 6/9/18 3:10 PM
 */
public class QuickSortTest {

    @Test
    public void test02() {
        QuickSort2.partition2(new Integer[]{5, 6, 2, 1, 0}, 0, 4);
    }

    @Test
    public void test1() {
        Integer[] arr = SortHelper.generateRandomArray(100000, 1, 10);
        SortHelper.testSort("com.wchb.course2.chapter3.QuickSort", arr);
        SortHelper.testSort("com.wchb.course2.chapter3.QuickSort2", arr);
    }

}
