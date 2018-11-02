import com.wchb.course2.chapter8.AcmeSubstring;
import com.wchb.course2.chapter8.AcmeSubstring;
import com.wchb.leetcode.SplittingPixels;
import com.wchb.mj.*;
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


    @Test
    public void test4() {
        System.out.println(new Music().numOfPlaylists(1, 1, 3));
    }

    @Test
    public void test5() {
        new FinalDiscountedPrice().finalDiscountedPriceV2(new int[]{5, 1, 3, 4, 6, 2});
        new FinalDiscountedPrice().finalDiscountedPriceV2(new int[]{1, 3, 3, 2, 5});
        System.out.println("---------");
        new FinalDiscountedPrice().finalDiscountedPriceV2(new int[]{5, 1, 3, 4, 6, 2});
        new FinalDiscountedPrice().finalDiscountedPriceV2(new int[]{1, 3, 3, 2, 5});
    }

    @Test
    public void test06() {
        System.out.println(new AcmeSubstring().firstOccurrence("xcattatcatta", "cat*a"));
        System.out.println(new AcmeSubstring().firstOccurrence("thisthisthisthis", "this"));
    }

    @Test
    public void test07() {
        System.out.println(new TaskMaster().solution(7,
                new int[]{1, 2, 3, 4, 6, 5},
                new int[]{7, 6, 4, 1, 2, 1}));
    }
}
