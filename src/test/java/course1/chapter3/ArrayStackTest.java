package course1.chapter3;

import com.wchb.course1.chapter3.ArrayStack;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayStackTest {

    private static final Logger logger = LoggerFactory.getLogger(ArrayStackTest.class);


    @Test
    public void test04() {

        ArrayStack<Integer> as = new ArrayStack<>(10);

        as.push(1);
        as.push(2);
        as.push(3);
        as.push(4);

        logger.info(" as :{}", as);
        logger.info(" as getFront:{}", as.peek());
        as.pop();
        logger.info(" as :{}", as);

    }
}
