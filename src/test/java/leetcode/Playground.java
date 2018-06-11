package leetcode;

import com.wchb.course1.chapter3.LoopQueue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @date 6/7/18 9:05 PM
 */
public class Playground {

    private static final Logger logger = LoggerFactory.getLogger(Playground.class);


    @Test
    public void test05() {
        //-2147483646
        int[] nums = new int[]{43, 16, 45, 89, 45, -2147483648, 45,
                2147483646, -2147483647, -2147483648, 43,
                2147483647, -7, -2147483648, 89,
                -7, 89, -7, -2147483647,
                2147483646, -2147483647, 16, 16, 2147483646, 43};
        Set<Integer> set = new HashSet<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, set.contains(n));
            set.add(n);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(Boolean.FALSE)) {
                System.out.println(entry.getKey());
            }
        }

    }

    @Test
    public void test04() {
        singleNumber2(new int[]{1, 1, 2, 2, 3});
    }

    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            logger.info("before ans: {} , num: {}", ans, nums[i]);
            ans = ans ^ nums[i];
            logger.info("after ans: {} , num: {}", ans, nums[i]);

        }

        logger.info(" result:  " + ans);
        return ans;
    }

    @Test
    public void test03() {

        int[] arr = new int[]{11, 22, 22};

        boolean isSingle = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] ^ arr[j]) == arr[i]) {

                }
            }
        }
    }

    @Test
    public void test02() {
        int l = 2;
        int r = 10;
        for (int i = 0; i < 1000; i++) {
            int result = (int) (Math.random() * (r - l + 1)) + l;
            if (result <= l || result >= r) {
                System.out.println(result);
            }
        }
    }

    @Test
    public void test01() {
        Arrays.copyOfRange(new Integer[]{1, 2, 3, 4, 5, 6}, 1, 2);
    }

    @Test
    public void test() {
        System.out.println(sum(100));
    }

    // 递归 求 1......i 的和
    private int sum(int i) {

        if (i == 1) {
            return 1;
        }

        return i + sum(i - 1);
    }
}
