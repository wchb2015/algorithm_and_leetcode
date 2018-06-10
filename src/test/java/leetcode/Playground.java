package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 6/7/18 9:05 PM
 */
public class Playground {

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
