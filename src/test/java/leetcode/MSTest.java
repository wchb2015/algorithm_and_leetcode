package leetcode;

import com.wchb.ms.S1;
import org.junit.Test;

/**
 * @date 7/26/18 7:35 PM
 */
public class MSTest {


    @Test
    public void test01() {
        new S1().unique(new int[]{1, 1, 2, 7, 8, 9, 15}, new int[]{0, 8, 10, 11, 12, 14, 14, 15});
        new S1().unique(new int[]{}, new int[]{});
    }
}
