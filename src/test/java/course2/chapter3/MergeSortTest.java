package course2.chapter3;

import com.wchb.course2.chapter3.MergeSort;
import com.wchb.course2.chapter3.MergeSortBU;
import com.wchb.course2.util.SortHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @date 6/8/18 9:44 PM
 */
public class MergeSortTest {

    @Test
    public void test02() {
        MergeSortBU.sort(SortHelper.generateRandomArray(8, 0, 100));
    }

    @Test
    public void test() {

        long startTime = System.currentTimeMillis();

        Integer[] arr = SortHelper.generateRandomArray(1000000, 1, 10000000);

//        System.out.println(Arrays.toString(arr));

        MergeSort.sort(arr);
//        System.out.println(Arrays.toString(arr));

        System.out.println("TimeUsed: " + (System.currentTimeMillis() - startTime));

    }

    @Test
    public void testBasic() {
        Integer[] arr = SortHelper.generateRandomArray(100, 1, 100);
        SortHelper.testSort("com.wchb.course2.chapter3.MergeSort", arr);
    }
}
