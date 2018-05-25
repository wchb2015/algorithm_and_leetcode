package course1.chapter3;

import com.wchb.course1.chapter3.ArrayQueue;
import com.wchb.course1.chapter3.IQueue;
import com.wchb.course1.chapter3.LoopQueue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class LoopQueueTest {

    private static final Logger logger = LoggerFactory.getLogger(LoopQueueTest.class);


    @Test
    public void test01() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        for (int i = 0; i < 15; i++) {
            loopQueue.enqueue(i);
            logger.info("loopQueue:{}, tail: {}, front:{}  ",
                    loopQueue, loopQueue.getTail(), loopQueue._getFront());
        }

        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();

        logger.info("loopQueue:{}, tail: {}, front:{}  ",
                loopQueue, loopQueue.getTail(), loopQueue._getFront());

        for (int i = 0; i < 15; i++) {
            loopQueue.enqueue(i);
            logger.info("loopQueue:{}, tail: {}, front:{}  ",
                    loopQueue, loopQueue.getTail(), loopQueue._getFront());
        }
    }


    @Test
    public void test02() {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
    }

    // 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testQueue(IQueue<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

}
