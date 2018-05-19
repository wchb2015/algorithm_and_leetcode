package course1.chapter3;

import com.wchb.course1.chapter3.ArrayQueue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayQueueTest {

    private static final Logger logger = LoggerFactory.getLogger(ArrayQueueTest.class);

    @Test
    public void test04() {

        ArrayQueue<Integer> aq = new ArrayQueue<>(10);

        aq.enqueue(1);
        aq.enqueue(2);
        aq.enqueue(3);
        aq.enqueue(4);
        aq.enqueue(5);

        logger.info(" aq :{}", aq);
        logger.info(" aq getFront:{}", aq.getFront());
        aq.dequeue();
        logger.info(" aq :{}", aq);

    }

}
