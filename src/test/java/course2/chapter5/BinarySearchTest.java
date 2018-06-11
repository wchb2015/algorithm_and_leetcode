package course2.chapter5;

import com.wchb.course2.chapter5.BinarySearch;
import org.junit.Test;

/**
 * @date 6/10/18 4:59 PM
 */
public class BinarySearchTest {

    @Test
    public void test() {
        int N = 100;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = new Integer(i);

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for (int i = 0; i < 2 * N; i++) {
            int v = BinarySearch.find2(arr, new Integer(i));
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }

        return;
    }
}
