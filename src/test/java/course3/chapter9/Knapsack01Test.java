package course3.chapter9;

import com.wchb.course3.chapter9.Knapsack01V1;
import com.wchb.course3.chapter9.Knapsack01V2;
import org.junit.Test;

/**
 * @date 7/25/18 1:49 PM
 */
public class Knapsack01Test {


    @Test
    public void test01() {
        Knapsack01V1 v1 = new Knapsack01V1();
        Knapsack01V2 v2 = new Knapsack01V2();

        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{6, 10, 12};
        int c = 5;

        System.out.println(v1.knapsack01(w, v, c));
        System.out.println(v2.knapsack01(w, v, c));
    }
}
