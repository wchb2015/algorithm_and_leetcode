package leetcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 6/7/18 9:05 PM
 */
public class Playground {

    private static final Logger logger = LoggerFactory.getLogger(Playground.class);


    @Test
    public void test06() {
        System.out.println(splitString("the sun is shining"));
        System.out.println(splitString("the \"sun is\" shining"));
        System.out.println(splitString("ab"));
        System.out.println(splitString("a"));
        System.out.println(splitString("a b"));
        System.out.println(splitString("\"a b\" c"));
        System.out.println(splitString("the \"sun is\" shining the \"sun is\" shining and \"good bad\""));
    }


    private List<String> splitString(String string) {
        List<String> ret = new ArrayList<>();

        String[] arr = string.split("\"");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
            if (arr[i].equals("")) {
                continue;
            }
            if (i % 2 == 1) {
                ret.add(arr[i]);
            } else {
                ret.addAll(Arrays.asList(arr[i].split(" ")));
            }
        }

        return ret;
    }

    @Test
    public void test05() {
        System.out.println((int) Math.pow(2, 10));

        List list = new LinkedList();

        list.add(null);
        list.add(null);
        list.add(null);

        System.out.println(list);

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
