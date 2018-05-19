package course1.chapter4;

import com.wchb.course1.chapter4.LinkedList;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListTest {
    private static final Logger logger = LoggerFactory.getLogger(ListTest.class);

    @Test
    public void test01() {

        LinkedList<Integer> list = new LinkedList<>();


        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        list.addLast(5);
        list.add(2, 666);
        logger.info("List:{}", list);

        list.remove(2);
        list.removeFirst();
        list.removeLast();

        list.set(1, 2222);

        logger.info("List:{}", list);
    }

}
