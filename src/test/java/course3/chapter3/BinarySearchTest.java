package course3.chapter3;

import com.wchb.course3.chapter3.BinarySearch;
import org.junit.Test;

/**
 * @date 6/16/18 10:31 AM
 */
public class BinarySearchTest {

    @Test
    public void test01() {
        System.out.println(BinarySearch.binarySearch(new Integer[]{1, 2, 3, 4}, 2));
        System.out.println(BinarySearch.binarySearch(new Integer[]{1}, 1));
        System.out.println(BinarySearch.binarySearchV2(new Integer[]{1}, 1));
    }
}
