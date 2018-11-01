import com.wchb.leetcode.SplittingPixels;
import com.wchb.mj.MinimumUniqueArraySum;
import com.wchb.mj.RoyalName;
import org.junit.Test;

import java.util.Arrays;

/**
 * @date 10/31/18 11:44 AM
 */
public class MJTest {

    @Test
    public void test01() {
        System.out.println(Arrays.toString(new RoyalName().
                solution(new String[]{"Peter V", "Peter VI", "Peter III", "Eve II"})));
    }


    @Test
    public void test02() {
        new MinimumUniqueArraySum().minSum(new int[]{1, 4, 4, 5});
    }

    @Test
    public void test03() {
        new SplittingPixels().solution(Arrays.asList(
                //"101111010110011011100100",
                // "110000010101011111101111",
                "000000001111111111111111"));
    }

}
