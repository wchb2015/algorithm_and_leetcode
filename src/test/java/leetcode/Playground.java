package leetcode;

import org.junit.Test;

/**
 * @date 6/7/18 9:05 PM
 */
public class Playground {

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
