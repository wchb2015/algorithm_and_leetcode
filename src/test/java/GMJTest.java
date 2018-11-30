import com.wchb.mj.dreamG.Email;
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
}
