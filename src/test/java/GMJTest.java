import com.wchb.mj.dreamG.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 11/29/18 8:53 AM
 */
// 狗家面经测试
public class GMJTest {

    General g = new General();

    @Test
    public void testS1() {
        List<List<String>> list1 = new LinkedList<>();
        list1.add(Arrays.asList("aa"));


        list1.add(Arrays.asList("b", "c"));
        list1.add(Arrays.asList("dd"));
        List<List<String>> list2 = new LinkedList<>();
        list2.add(Arrays.asList("aa", "b"));
        list2.add(Arrays.asList("c", "dd"));
        list2.add(Arrays.asList("e", "g"));
        System.out.println(g.solution1(list1));
        System.out.println(g.solution1(list2));
    }


    @Test
    public void testOneAdd() {
        System.out.println(g.oneAdd("abc", "ababc"));//true
        System.out.println(g.oneAdd("abc", "acbdc"));//false
    }

    @Test
    public void testMonarchy() {
        Monarchy m = new Monarchy();

        m.birth("a1", "root_king");
        m.birth("a2", "root_king");


        m.birth("b1", "a1");
        m.birth("b2", "a1");
        m.birth("d1", "b1");
        m.birth("d2", "b1");
        m.birth("d3", "b2");


        m.birth("c1", "a2");
        m.birth("c2", "a2");


        System.out.println(m.getOrderOfSuccession());

    }


    @Test
    public void testNextGreatSteps() {
        new NextGreatSteps().solution(new int[]{5, 3, 1, 2, 4});
        new NextGreatSteps().solution(new int[]{1, 2, 3, 4, 5});
        new NextGreatSteps().solution(new int[]{5, 4, 3, 2, 1});
    }


    @Test
    public void testConnectedCells() {
        new ConnectedCells().getBiggestRegionV2(new int[][]{
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1}
        });
    }


    @Test
    public void testBoggle() {
        System.out.println(new BoggleV3().findWords(new char[][]{{'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}}, new String[]{"GEEKS", "FOR", "QUIZ", "GEE"}));
    }

    @Test
    public void testEmail() {

        Email email = new Email();

        System.out.println(email.solution(new String[]{
                "a.b@example.com", "dupli......cate@example.com",
                "d.u.p.l.i.c.a.t.e@example.com", "ab+work@example.com"
        }));

    }


    @Test
    public void testMatrixOfWords() {
        boolean res = new MatrixOfWords().solution(new String[][]{
                {"cat", "dog", "tail"}, {"target", "tag", "goal"}
        }, "cat", "goal");

        System.out.println(res);
    }

    @Test
    public void testNumberOfSubstringsWithoutUsingAllAlphabets() {
        System.out.println(new NumberOfSubstringsWithoutUsingAllAlphabets().solution(
                "abbacaaaa", new char[]{'a', 'b', 'c'}
        ));
    }

    @Test
    public void testStringOrder() {
        System.out.println(new StringOrder().solution("google", "gole"));//false
        System.out.println(new StringOrder().solution("google", "gle"));//true
    }
}
