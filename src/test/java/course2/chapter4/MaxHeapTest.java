package course2.chapter4;

import com.wchb.course2.chapter4.MaxHeap;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @date 5/31/18 2:34 PM
 */
public class MaxHeapTest {

    Integer[] nums;
    Random random = new Random();
    MaxHeap<Integer> maxHeap;
    int size;


    @Before
    public void init() {
        size = 30;
        nums = new Integer[size];

        for (int i = 0; i < size; i++) {
            nums[i] = random.nextInt(100);
        }
    }

    @Test
    public void test01() {

        maxHeap = new MaxHeap<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            maxHeap.add(random.nextInt(100));
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            nums.add(maxHeap.extractMax());
        }

        System.out.println(nums.toString());
    }

}
