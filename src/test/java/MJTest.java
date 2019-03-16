import com.wchb.course2.chapter8.AcmeSubstring;
import com.wchb.leetcode.SplittingPixels;
import com.wchb.mj.any.TTT;
import com.wchb.mj.coursera.*;
import com.wchb.mj.dreamA.A01;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @date 10/31/18 11:44 AM
 */
public class MJTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TTT t = new TTT();
        t.initializeBoard();


        do {

            System.out.println(" input row(0-2): ");
            int row = scanner.nextInt();
            System.out.println(" input column(0-2): ");
            int column = scanner.nextInt();

            t.setBoard(row, column, 'X');
            t.printBoard();

        } while (true);
    }


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
        System.out.println(new AcmeSubstring().firstOccurrence("juliasamanthant", "ant"));
    }

    @Test
    public void test07() {
        System.out.println(new TaskMaster().solution(7,
                new int[]{1, 2, 3, 4, 6, 5},
                new int[]{7, 6, 4, 1, 2, 1}));
        System.out.println(new TaskMaster().solution(2, new int[]{1, 2}, new int[]{2, 1}));
        System.out.println(new TaskMaster().solution(2, new int[]{}, new int[]{}));
    }


    @Test
    public void test08() {
        System.out.println(new PackingMelons().solution(
                new int[]{5, 1, 4, 3, 2},
                new int[]{6, 2, 7, 5, 1}));


        System.out.println(new PackingMelons().solution(
                new int[]{5, 1, 4, 3, 2},
                new int[]{1, 1, 1, 3, 1}));
    }


    @Test
    public void test09() {
        System.out.println(new Triplets().solution(new int[]{5, 1, 4, 3, 2}, 10));
        System.out.println("-----------------------------------------------------");
        System.out.println(new Triplets().solution(new int[]{5, 1, 4, 3, 2}, 20));
    }


    @Test
    public void test10() {
        //1770
        System.out.println(new CuttingMetalSurplus().solution(1, 10, new int[]{26, 103, 59}));
        System.out.println("-----------------------------------------------------");
        //1230
        System.out.println(new CuttingMetalSurplus().solution(100, 10, new int[]{
                3, 26, 103, 59
        }));
        //10
        System.out.println(new CuttingMetalSurplus().solution(1000, 1, new int[]{
                6, 5, 5
        }));

    }

    @Test
    public void test11() {
        System.out.println(new ApproximateMatching().solution2("nothing", "bruno", "ingenious"));
        System.out.println(new ApproximateMatching().solution2("ab", "b", "a"));
        System.out.println(new ApproximateMatching().solution2("ba", "c", "d"));
        System.out.println(new ApproximateMatching().solution2("engine", "raven", "ginkngo"));
    }


    @Test
    public void test12() {
        Assert.assertEquals("!!!", "1100", new MagicBinaryString().solution("1100"));
        Assert.assertEquals("!!!", "11100100", new MagicBinaryString().solution("11011000"));

        Assert.assertEquals("!!!", "1101001100", new MagicBinaryString().solution("1101001100"));
        Assert.assertEquals("!!!", "1110010010", new MagicBinaryString().solution("1101100010"));
        Assert.assertEquals("!!!", "1100101100", new MagicBinaryString().solution("1011001100"));


    }


    @Test
    public void test13() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(2);
        arrayList.add(6);

        arrayList.add(1);

        Collections.sort(arrayList);
        System.out.println(arrayList);


        System.out.println(arrayList.get(arrayList.size() - 1));
    }


    @Test
    public void test14() {
        System.out.println(new A01().mergeFiles(new int[]{2, 6, 1, 8}));
    }

    @Test
    public void test15() {

        int capacity = 10000;
        List<int[]> f = new LinkedList<>();
        List<int[]> b = new LinkedList<>();

        f.add(new int[]{1, 2000});
        b.add(new int[]{1, 8000});
        b.add(new int[]{2, 8000});
        new A01().approximateMemUsage(f, b, capacity);
    }


    @Test
    public void test16() {
        int numTotalAvailableCities = 6;
        int numTotalAvailRoads = 3;
        List<int[]> roadsAvailable = new LinkedList<>();
        roadsAvailable.add(new int[]{1, 4});
        roadsAvailable.add(new int[]{4, 5});
        roadsAvailable.add(new int[]{2, 3});

        int numNewRoadsConstruct = 4;
        List<int[]> numNewRoadsConstructCost = new LinkedList<>();
        numNewRoadsConstructCost.add(new int[]{1, 2, 5});
        numNewRoadsConstructCost.add(new int[]{1, 3, 10});
        numNewRoadsConstructCost.add(new int[]{1, 6, 2});
        numNewRoadsConstructCost.add(new int[]{5, 6, 5});

        new A01().mst(numTotalAvailableCities,
                numTotalAvailRoads,
                roadsAvailable,
                numNewRoadsConstruct,
                numNewRoadsConstructCost);
    }
}
