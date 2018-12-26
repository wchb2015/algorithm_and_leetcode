import com.wchb.mj.dreamG.*;
import org.junit.Test;

/**
 * @date 11/29/18 8:53 AM
 */
// 狗家面经测试
public class GMJTest {


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
