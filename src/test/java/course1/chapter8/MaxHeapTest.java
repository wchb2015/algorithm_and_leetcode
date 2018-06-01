package course1.chapter8;

import com.wchb.course1.chapter8.MaxHeap;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @date 5/30/18 11:34 PM
 */
public class MaxHeapTest {

    Integer[] nums;
    Random random = new Random();
    MaxHeap<Integer> maxHeap;


    @Before
    public void init() {
        int n = 1000;
        nums = new Integer[n];

        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(1000);
        }
    }

    @Test
    public void test01() {
        int n = 100;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(1000));
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(maxHeap.extractMax());
        }

        System.out.println(nums.toString());
    }

    @Test
    public void testHeapify() {
        boolean isHeapify = false;

        if (isHeapify) {
            maxHeap = new MaxHeap<>(nums);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num : nums) {
                maxHeap.add(num);
            }
        }

        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < nums.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");
    }

}
