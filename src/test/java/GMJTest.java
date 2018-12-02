import com.wchb.mj.dreamG.Email;
import com.wchb.mj.dreamG.MatrixOfWords;
import com.wchb.mj.dreamG.NumberOfSubstringsWithoutUsingAllAlphabets;
import com.wchb.mj.dreamG.StringOrder;
import org.junit.Test;

/**
 * @date 11/29/18 8:53 AM
 */
// 狗家面经测试
public class GMJTest {

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
